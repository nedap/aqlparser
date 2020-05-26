package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;

public class ContainsExpression extends NodeExpression {

    public ContainsExpression(AQLParser.ContainsExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ContainsExprContext ctx) {
        if (ctx.OPEN() != null) initialize(ctx.containsExpr(0));
        setObject(ctx.CONTAINS(),ctx.classExprOperand(), ctx.AND(), ctx.XOR(), ctx.OR());
        addChildren(
                (ctx.CONTAINS() != null) ? ctx.classExprOperand() : null,
                ctx.containsExpr(0),
                ctx.containsExpr(1));
    }

}
