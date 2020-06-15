package com.nedap.healthcare.aqlparser.util;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.*;
import com.nedap.healthcare.aqlparser.model.leaf.*;
import com.nedap.healthcare.aqlparser.model.predicate.*;
import com.nedap.healthcare.aqlparser.model.leaf.NodePredicateExprOperand;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class QOMParserUtil {

    public static QOMObject parse(ParseTree parseTree) {
        return parse(new ParseTree[]{parseTree}).get(0);
    }

    public static List<QOMObject> parse(ParseTree... parseTrees) {
        List<QOMObject> objects = new ArrayList<>();
        for (ParseTree parseTree : parseTrees) {
            if (parseTree == null) continue;
            if (parseTree instanceof TerminalNode) {
                objects.add(parse((TerminalNode) parseTree));
            } else if (parseTree instanceof ParserRuleContext) {
                objects.add(parse((ParserRuleContext) parseTree));
            } else {
                throw new RuntimeException("NYI");
            }
        }
        return objects;
    }

    public static QOMObject parse(TerminalNode terminalNode) {
        return QOMParserUtil.parse(new TerminalNode[]{terminalNode}).get(0);
    }

    public static List<QOMObject> parse(TerminalNode... terminalNodes) {
        List<QOMObject> objects = new ArrayList<>();
        for (TerminalNode terminalNode : terminalNodes) {
            if (terminalNode == null) continue;
            int type = terminalNode.getSymbol().getType();
            switch (type) {
                case AQLParser.NODEID :
                    objects.add(new NodeId(terminalNode));
                    break;
                case AQLParser.PARAMETER:
                    objects.add(new PrimitiveOperand(PrimitiveType.PARAMETER,terminalNode.getText()));
                    break;
                case AQLParser.ARCHETYPEID:
                    objects.add(new ArchetypeId(terminalNode));
                    break;
                case AQLParser.URIVALUE:
                    objects.add(new URIValue(terminalNode));
                    break;
                case AQLParser.STRING:
                    objects.add(new PrimitiveOperand(PrimitiveType.STRING,terminalNode.getText()));
                    break;
                case AQLParser.INTEGER:
                    objects.add(new PrimitiveOperand(PrimitiveType.INTEGER,terminalNode.getText()));
                    break;
                case AQLParser.FLOAT:
                    objects.add(new PrimitiveOperand(PrimitiveType.FLOAT,terminalNode.getText()));
                    break;
                case AQLParser.DATE:
                    objects.add(new PrimitiveOperand(PrimitiveType.DATE,terminalNode.getText()));
                    break;
                case AQLParser.BOOLEAN:
                    objects.add(new PrimitiveOperand(PrimitiveType.BOOLEAN,terminalNode.getText()));
                    break;
                case AQLParser.REGEXPATTERN:
                    objects.add(new RegexPattern(terminalNode));
                    break;
                case AQLParser.COMPARABLEOPERATOR:
                case AQLParser.AND:
                case AQLParser.OR:
                case AQLParser.XOR:
                case AQLParser.NOT:
                case AQLParser.EXISTS:
                case AQLParser.MATCHES:
                case AQLParser.CONTAINS:
                    objects.add(new Operator(terminalNode));
                    break;
                default:
                    throw new RuntimeException("NYI");
            }
        }
        return objects;
    }

    public static QOMObject parse(ParserRuleContext parserRuleContext) {
        return QOMParserUtil.parse(new ParserRuleContext[]{parserRuleContext}).get(0);
    }

    public static List<QOMObject> parse(ParserRuleContext... parserRuleContexts) {
        List<QOMObject> objects = new ArrayList<>();
        for (ParserRuleContext ctx : parserRuleContexts) {
            if (ctx == null) continue;
            if (ctx instanceof AQLParser.IdentifiedExprContext) {
                objects.add(new IdentifiedExpression((AQLParser.IdentifiedExprContext) ctx));
            } else if (ctx instanceof AQLParser.IdentifiedExprOperandContext) {
                objects.add(new IdentifiedExprOperand((AQLParser.IdentifiedExprOperandContext) ctx));
            } else if (ctx instanceof AQLParser.MatchesOperandContext) {
                AQLParser.MatchesOperandContext moctx = (AQLParser.MatchesOperandContext) ctx;
                List<QOMObject> trest123 = parse(moctx.valueList(), moctx.URIVALUE());
                objects.add(parse(moctx.valueList(), moctx.URIVALUE()).get(0));
            }else if (ctx instanceof AQLParser.ValueListContext) {
                objects.add(new ValueList((AQLParser.ValueListContext) ctx));
            } else if (ctx instanceof AQLParser.PredicateOperandContext) {
                AQLParser.PredicateOperandContext poctx = (AQLParser.PredicateOperandContext) ctx;
                if (poctx.identifiedPath() != null &&
                        poctx.identifiedPath().objectPath() == null &&
                        poctx.identifiedPath().nodePredicate() == null) {
                    //If only an IDENTIFIER is specified, an IdentifiedPath can not be distinguished from a
                    //PrimitiveOperand of type String.
                    objects.add(new PrimitiveOperand(PrimitiveType.STRING,poctx.identifiedPath().IDENTIFIER().getText()));
                } else {
                    objects.addAll(QOMParserUtil.parse(poctx.identifiedPath(),poctx.primitiveOperand()));
                }
            } else if (ctx instanceof AQLParser.PrimitiveOperandContext) {
                objects.add(new PrimitiveOperand((AQLParser.PrimitiveOperandContext) ctx));
            } else if (ctx instanceof AQLParser.ArchetypePredicateExprContext) {
                AQLParser.ArchetypePredicateExprContext apctx = (AQLParser.ArchetypePredicateExprContext) ctx;
                objects.add(parse(apctx.ARCHETYPEID(),apctx.PARAMETER(),apctx.REGEXPATTERN()).get(0));
            } else if (ctx instanceof AQLParser.PathPartContext) {
                objects.add(new PathPart((AQLParser.PathPartContext) ctx));
            } else if (ctx instanceof AQLParser.ObjectPathContext) {
                objects.add(new ObjectPath((AQLParser.ObjectPathContext) ctx));
            } else if (ctx instanceof AQLParser.NodePredicateContext) {
                objects.add(new NodePredicate((AQLParser.NodePredicateContext) ctx));
            } else if (ctx instanceof AQLParser.NodePredicateExprContext) {
                objects.add(new NodePredicateExpression((AQLParser.NodePredicateExprContext) ctx));
            } else if (ctx instanceof AQLParser.NodePredicateExprOperandContext) {
                objects.add(new NodePredicateExprOperand((AQLParser.NodePredicateExprOperandContext) ctx));
            } else if (ctx instanceof AQLParser.QueryClauseContext) {
                objects.add(new QueryClause((AQLParser.QueryClauseContext) ctx));
            } else if (ctx instanceof AQLParser.ClassExprOperandContext) {
                objects.add(new ClassExprOperand((AQLParser.ClassExprOperandContext) ctx));
            } else if (ctx instanceof AQLParser.ContainsExprContext) {
                objects.add(new ContainsExpression((AQLParser.ContainsExprContext) ctx));
            } else if (ctx instanceof AQLParser.FromClauseContext) {
                objects.add(new FromClause((AQLParser.FromClauseContext) ctx));
            } else if (ctx instanceof AQLParser.ArchetypePredicateContext) {
                objects.add(new ArchetypePredicate((AQLParser.ArchetypePredicateContext) ctx));
            } else if (ctx instanceof AQLParser.IdentifiedPathContext) {
                objects.add(new IdentifiedPath((AQLParser.IdentifiedPathContext) ctx));
            } else if (ctx instanceof AQLParser.SelectOperandContext) {
                objects.add(new SelectOperand((AQLParser.SelectOperandContext) ctx));
            } else if (ctx instanceof AQLParser.SelectClauseContext) {
                objects.add(new SelectClause((AQLParser.SelectClauseContext) ctx));
            } else if (ctx instanceof AQLParser.TopClauseContext) {
                objects.add(new TopClause((AQLParser.TopClauseContext) ctx));
            } else if (ctx instanceof AQLParser.OrderByExprContext) {
                objects.add(new OrderByExpression((AQLParser.OrderByExprContext) ctx));
            } else if (ctx instanceof AQLParser.OrderByClauseContext) {
                objects.add(new OrderByClause((AQLParser.OrderByClauseContext) ctx));
            } else if (ctx instanceof AQLParser.StandardPredicateExprContext) {
                objects.add(new StandardPredicateExpression((AQLParser.StandardPredicateExprContext) ctx));
            } else if (ctx instanceof AQLParser.StandardPredicateContext) {
                objects.add(new StandardPredicate((AQLParser.StandardPredicateContext) ctx));
            } else if (ctx instanceof AQLParser.StandardPredicateExprOperandContext) {
                objects.add(new StandardPredicateExprOperand((AQLParser.StandardPredicateExprOperandContext) ctx));
            } else if (ctx instanceof AQLParser.WhereClauseContext) {
                objects.add(new WhereClause((AQLParser.WhereClauseContext) ctx));
            } else {
                throw new RuntimeException("NYI");
            }
        }
        return objects;
    }

}
