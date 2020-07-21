package com.nedap.healthcare.aqlparser.util;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLUnsupportedFeatureException;
import com.nedap.healthcare.aqlparser.model.*;
import com.nedap.healthcare.aqlparser.model.clause.*;
import com.nedap.healthcare.aqlparser.model.leaf.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class QOMParserUtil {

    public static QOMObject parse(Lookup lookup, ParseTree parseTree) {
        return parse(lookup, new ParseTree[]{parseTree}).get(0);
    }

    public static List<QOMObject> parse(Lookup lookup, ParseTree... parseTrees) {
        List<QOMObject> objects = new ArrayList<>();
        for (ParseTree parseTree : parseTrees) {
            if (parseTree == null) continue;
            if (parseTree instanceof TerminalNode) {
                objects.add(parse(lookup, (TerminalNode) parseTree));
            } else if (parseTree instanceof ParserRuleContext) {
                objects.add(parse(lookup, (ParserRuleContext) parseTree));
            }
        }
        return objects;
    }

    public static QOMObject parse(Lookup lookup, TerminalNode terminalNode) {
        return QOMParserUtil.parse(lookup, new TerminalNode[]{terminalNode}).get(0);
    }

    public static List<QOMObject> parse(Lookup lookup, TerminalNode... terminalNodes) {
        List<QOMObject> objects = new ArrayList<>();
        for (TerminalNode terminalNode : terminalNodes) {
            if (terminalNode == null) continue;
            int type = terminalNode.getSymbol().getType();
            switch (type) {
                case AQLParser.NODEID :
                case AQLParser.URIVALUE:
                    objects.add(new TerminalNodeLeaf(terminalNode));
                    break;
                case AQLParser.PARAMETER:
                    objects.add(new PrimitiveOperand(PrimitiveType.PARAMETER,terminalNode.getText(), lookup));
                    break;
                case AQLParser.ARCHETYPEID:
                    objects.add(new ArchetypeId(terminalNode));
                    break;
                case AQLParser.STRING:
                    objects.add(new PrimitiveOperand(PrimitiveType.STRING,terminalNode.getText(), lookup));
                    break;
                case AQLParser.INTEGER:
                    objects.add(new PrimitiveOperand(PrimitiveType.INTEGER,terminalNode.getText(), lookup));
                    break;
                case AQLParser.FLOAT:
                    objects.add(new PrimitiveOperand(PrimitiveType.FLOAT,terminalNode.getText(), lookup));
                    break;
                case AQLParser.DATE:
                    objects.add(new PrimitiveOperand(PrimitiveType.DATE,terminalNode.getText(), lookup));
                    break;
                case AQLParser.BOOLEAN:
                    objects.add(new PrimitiveOperand(PrimitiveType.BOOLEAN,terminalNode.getText(), lookup));
                    break;
                case AQLParser.COMPARABLEOPERATOR:
                case AQLParser.AND:
                case AQLParser.OR:
                case AQLParser.NOT:
                case AQLParser.EXISTS:
                case AQLParser.MATCHES:
                case AQLParser.CONTAINS:
                    objects.add(new Operator(terminalNode));
                    break;
                default:
                    throw new AQLUnsupportedFeatureException(terminalNode.getSymbol() + " not yet supported in QOMParserUtil");
            }
        }
        return objects;
    }

    public static QOMObject parse(Lookup lookup, ParserRuleContext parserRuleContext) {
        return QOMParserUtil.parse(lookup, new ParserRuleContext[]{parserRuleContext}).get(0);
    }

    public static List<QOMObject> parse(Lookup lookup, ParserRuleContext... parserRuleContexts) {
        List<QOMObject> objects = new ArrayList<>();
        for (ParserRuleContext ctx : parserRuleContexts) {
            if (ctx == null) continue;
            if (ctx instanceof AQLParser.IdentifiedExprContext) {
                objects.add(new NodeExpression((AQLParser.IdentifiedExprContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.IdentifiedExprOperandContext) {
                objects.add(new IdentifiedExprOperand((AQLParser.IdentifiedExprOperandContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.MatchesOperandContext) {
                AQLParser.MatchesOperandContext moctx = (AQLParser.MatchesOperandContext) ctx;
                objects.add(parse(lookup, moctx.valueList(), moctx.URIVALUE()).get(0));
            } else if (ctx instanceof AQLParser.ValueListContext) {
                objects.add(new ValueList((AQLParser.ValueListContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.PredicateOperandContext) {
                AQLParser.PredicateOperandContext poctx = (AQLParser.PredicateOperandContext) ctx;
                if (poctx.identifiedPath() != null &&
                        poctx.identifiedPath().objectPath() == null &&
                        poctx.identifiedPath().nodePredicate() == null) {
                    //If only an IDENTIFIER is specified, an IdentifiedPath can not be distinguished from a
                    //PrimitiveOperand of type String.
                    objects.add(new PrimitiveOperand(PrimitiveType.STRING,poctx.identifiedPath().IDENTIFIER().getText(), lookup));
                } else {
                    objects.addAll(QOMParserUtil.parse(lookup, poctx.identifiedPath(),poctx.primitiveOperand()));
                }
            } else if (ctx instanceof AQLParser.PrimitiveOperandContext) {
                objects.add(new PrimitiveOperand((AQLParser.PrimitiveOperandContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.ArchetypePredicateExprContext) {
                AQLParser.ArchetypePredicateExprContext apctx = (AQLParser.ArchetypePredicateExprContext) ctx;
                objects.add(parse(lookup, apctx.ARCHETYPEID(),apctx.PARAMETER()).get(0));
            } else if (ctx instanceof AQLParser.PathPartContext) {
                objects.add(new PathPart((AQLParser.PathPartContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.ObjectPathContext) {
                objects.add(new ObjectPath((AQLParser.ObjectPathContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.NodePredicateContext) {
                objects.add(new Predicate((AQLParser.NodePredicateContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.NodePredicateExprContext) {
                objects.add(new NodeExpression((AQLParser.NodePredicateExprContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.NodePredicateExprOperandContext) {
                objects.add(new NodeExpression((AQLParser.NodePredicateExprOperandContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.QueryClauseContext) {
                objects.add(new QueryClause((AQLParser.QueryClauseContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.ClassExprOperandContext) {
                objects.add(new ClassExprOperand((AQLParser.ClassExprOperandContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.ContainsExprContext) {
                objects.add(new NodeExpression((AQLParser.ContainsExprContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.FromClauseContext) {
                objects.add(new FromClause((AQLParser.FromClauseContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.ArchetypePredicateContext) {
                objects.add(new ArchetypePredicate((AQLParser.ArchetypePredicateContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.IdentifiedPathContext) {
                objects.add(new IdentifiedPath((AQLParser.IdentifiedPathContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.SelectOperandContext) {
                objects.add(new SelectOperand((AQLParser.SelectOperandContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.SelectClauseContext) {
                objects.add(new SelectClause((AQLParser.SelectClauseContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.TopClauseContext) {
                objects.add(new TopClause((AQLParser.TopClauseContext) ctx));
            } else if (ctx instanceof AQLParser.OrderByExprContext) {
                objects.add(new OrderByExpression((AQLParser.OrderByExprContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.OrderByClauseContext) {
                objects.add(new OrderByClause((AQLParser.OrderByClauseContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.StandardPredicateExprContext) {
                objects.add(new NodeExpression((AQLParser.StandardPredicateExprContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.StandardPredicateContext) {
                objects.add(new Predicate((AQLParser.StandardPredicateContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.StandardPredicateExprOperandContext) {
                objects.add(new NodeExpression((AQLParser.StandardPredicateExprOperandContext) ctx, lookup));
            } else if (ctx instanceof AQLParser.WhereClauseContext) {
                objects.add(new WhereClause((AQLParser.WhereClauseContext) ctx, lookup));
            } else {
                throw new AQLUnsupportedFeatureException(ctx.getClass().getCanonicalName() + " not yet supported in QOMParserUtil");
            }
        }
        return objects;
    }

}
