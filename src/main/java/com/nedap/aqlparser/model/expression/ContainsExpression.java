package com.nedap.aqlparser.model.expression;

import com.nedap.aqlparser.AQLParser;
public class ContainsExpression extends Expression {

    public ContainsExpression(AQLParser.ContainsExpressionContext ctx) {
        initializeExpression(ctx);
    }

    private void initializeExpression(AQLParser.ContainsExpressionContext ctx) {
        if (ctx.AND() != null || ctx.OR() != null) {
            this.expression = new Operator();
            ((Operator) expression).setLeftOperand(new ContainsExpression(ctx.containsExpression(0)));
            ((Operator) expression).setRightOperand(new ContainsExpression(ctx.containsExpression(1)));
            ((Operator) expression).setType((ctx.AND() != null) ? OperatorType.AND : OperatorType.OR);
        } else if (ctx.OPEN() != null) {
            initializeExpression(ctx.containsExpression(0));
        } else if (ctx.classExpr() != null) {
            this.expression = new ClassExpression(ctx.classExpr());
        } else {
            throw new RuntimeException("NYI");
        }
    }

}
