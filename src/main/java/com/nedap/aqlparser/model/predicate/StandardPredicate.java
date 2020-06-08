package com.nedap.aqlparser.model.predicate;

import com.nedap.aqlparser.AQLParser;

public class StandardPredicate extends Predicate {


    public StandardPredicate(AQLParser.StandardPredicateContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.StandardPredicateContext ctx) {
        predicateExpression = new StandardPredicateExpression(ctx.standardPredicateExpr());
    }


}
