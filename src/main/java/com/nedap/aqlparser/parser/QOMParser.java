package com.nedap.aqlparser.parser;

import com.nedap.aqlparser.AQLBaseVisitor;
import com.nedap.aqlparser.AQLLexer;
import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.TopClause;
import com.nedap.aqlparser.model.*;
import com.nedap.aqlparser.model.expression.ClassExpression;
import com.nedap.aqlparser.model.expression.ContainsExpression;
import com.nedap.aqlparser.model.expression.IdentifiedPath;
import com.nedap.aqlparser.model.expression.ValueList;
import com.nedap.aqlparser.model.expression.predicate.NodePredicate;
import com.nedap.aqlparser.model.expression.predicate.StandardPredicate;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QOMParser extends AQLBaseVisitor<QOMObject> {

    public static QOMObject parse(String aql, String startRuleName) {
        final CharStream input = CharStreams.fromString(aql);
        final AQLLexer lexer = new AQLLexer(input);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokenStream);
        ParseTree parseTree;
        try {
            Method method = parser.getClass().getMethod(startRuleName);
            parseTree = (ParseTree) method.invoke(parser);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Could not invoke ParseTree.startRuleName",e);
        }
        final QOMParser visitor = new QOMParser();
        QOMObject object = visitor.visit(parseTree);
        if (object == null) throw new RuntimeException("Visitor for " + startRuleName + " not yet implement");
        return object;
    }

    @Override
    public QOMObject visitNodePredicate(AQLParser.NodePredicateContext ctx) {
        return new NodePredicate(ctx);
    }

    @Override
    public QOMObject visitPathPart(AQLParser.PathPartContext ctx) {
        return new PathPart(ctx);
    }

    @Override
    public QOMObject visitIdentifiedPath(AQLParser.IdentifiedPathContext ctx) {
        return new IdentifiedPath(ctx);
    }

    @Override
    public QOMObject visitClassExpr(AQLParser.ClassExprContext ctx) {
        return new ClassExpression(ctx);
    }

    @Override
    public QOMObject visitContainsExpression(AQLParser.ContainsExpressionContext ctx) {
        return new ContainsExpression(ctx);
    }

    @Override
    public QOMObject visitContains(AQLParser.ContainsContext ctx) {
        return new Containment(ctx);
    }

    @Override
    public QOMObject visitValueListItems(AQLParser.ValueListItemsContext ctx) {
        return new ValueList(ctx);
    }

    @Override
    public QOMObject visitStandardPredicate(AQLParser.StandardPredicateContext ctx) {
        return new StandardPredicate(ctx);
    }

    @Override
    public QOMObject visitStandardPredicateExpr(AQLParser.StandardPredicateExprContext ctx) {
        return new StandardPredicate(ctx);
    }

    @Override
    public QOMObject visitSelectClause(AQLParser.SelectClauseContext ctx) {
        return new SelectClause(ctx);
    }

    @Override
    public QOMObject visitTopClause(AQLParser.TopClauseContext ctx) {
        return new TopClause(ctx);
    }

    @Override
    public QOMObject visitFromClause(AQLParser.FromClauseContext ctx) {
        return new FromClause(ctx);
    }

    @Override
    public QOMObject visitWhereClause(AQLParser.WhereClauseContext ctx) {
        return new WhereClause(ctx);
    }

    @Override
    public QOMObject visitQuery(AQLParser.QueryContext ctx) {
        return new Query(ctx);
    }

}
