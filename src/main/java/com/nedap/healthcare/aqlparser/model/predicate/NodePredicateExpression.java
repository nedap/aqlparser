package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.NodeExpression;

public class NodePredicateExpression extends NodeExpression {

    public NodePredicateExpression(AQLParser.NodePredicateExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.NodePredicateExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.nodePredicateExpr(0));
            return;
        }
        setObject(ctx.AND(),ctx.OR(),ctx.nodePredicateExprOperand());
        addChildren(ctx.nodePredicateExpr(0),ctx.nodePredicateExpr(1));
    }

}
