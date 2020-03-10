package com.nedap.aqlparser.model.expression;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.parser.QOMParserUtil;

public class IdentifiedExpression extends Expression {

    public IdentifiedExpression(AQLParser.IdentifiedExprContext ctx) {
        initializeExpression(ctx);
    }

    private void initializeExpression(AQLParser.IdentifiedExprContext ctx) {
        if (ctx.AND() != null || ctx.OR() != null) {
            this.expression = new Operator();
            ((Operator) expression).setLeftOperand(new IdentifiedExpression(ctx.identifiedExpr(0)));
            ((Operator) expression).setRightOperand(new IdentifiedExpression(ctx.identifiedExpr(1)));
            ((Operator) expression).setType((ctx.AND() != null) ? OperatorType.AND : OperatorType.OR);
        } else if (ctx.OPEN() != null) {
            initializeExpression(ctx.identifiedExpr(0));
        } else if (ctx.predicateOperand(0) != null) {
            this.expression = new Operator();
            ((Operator) expression).setLeftOperand(QOMParserUtil.parsePredicateOperand(ctx.predicateOperand(0)));
            if (ctx.COMPARABLEOPERATOR() != null) {
                ((Operator) expression).setRightOperand(QOMParserUtil.parsePredicateOperand(ctx.predicateOperand(1)));
            } else if (ctx.MATCHES() != null) {
                ((Operator) expression).setRightOperand(QOMParserUtil.parseMatchesOperand(ctx.matchesOperand()));
            }
        } else {
            throw new RuntimeException("NYI");
        }
    }
}
