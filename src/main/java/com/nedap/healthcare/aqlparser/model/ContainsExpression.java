package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;

public class ContainsExpression extends NodeExpression {

    public ContainsExpression(AQLParser.ContainsExprContext ctx, Lookup lookup) {
        setLookup(lookup);
        initialize(ctx);
    }

    private void initialize(AQLParser.ContainsExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.containsExpr(0));
            return;
        }
        setObject(ctx.CONTAINS(),ctx.classExprOperand(), ctx.AND(), ctx.XOR(), ctx.OR());
        addChildren(
                (ctx.CONTAINS() != null) ? ctx.classExprOperand() : null,
                ctx.containsExpr(0),
                ctx.containsExpr(1));
    }

}
