package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;

public class IdentifiedExpression extends NodeExpression {

    public IdentifiedExpression(AQLParser.IdentifiedExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.identifiedExpr(0));
            return;
        }
        setObject(ctx.identifiedExprOperand(), ctx.NOT(), ctx.EXISTS(), ctx.AND(), ctx.XOR(), ctx.OR());
        addChildren(ctx.identifiedExpr(0), ctx.identifiedExpr(1));
    }

}
