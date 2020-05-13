package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.util.QOMParserUtil;

public class IdentifiedExpression extends NodeExpression {

    public IdentifiedExpression(AQLParser.IdentifiedExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedExprContext ctx) {
        if (ctx.OPEN() != null) initialize(ctx.identifiedExpr(0));
        setObject(ctx.identifiedExprOperand(), ctx.NOT(), ctx.EXISTS(), ctx.AND(), ctx.XOR(), ctx.OR());
        addChildren(ctx.identifiedExpr(0), ctx.identifiedExpr(1));
    }

}
