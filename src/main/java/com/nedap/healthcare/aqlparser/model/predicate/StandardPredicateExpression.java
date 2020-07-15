package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.NodeExpression;

public class StandardPredicateExpression extends NodeExpression {

    public StandardPredicateExpression(AQLParser.StandardPredicateExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.StandardPredicateExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.standardPredicateExpr(0));
            return;
        }
        setObject(ctx.standardPredicateExprOperand(),ctx.NOT(),ctx.AND(),ctx.OR());
        addChildren(ctx.standardPredicateExpr(0),ctx.standardPredicateExpr(1));
    }
}
