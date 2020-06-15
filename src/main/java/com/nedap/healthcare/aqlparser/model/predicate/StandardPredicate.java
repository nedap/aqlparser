package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.AQLParser;

public class StandardPredicate extends Predicate {


    public StandardPredicate(AQLParser.StandardPredicateContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.StandardPredicateContext ctx) {
        predicateExpression = new StandardPredicateExpression(ctx.standardPredicateExpr());
    }


}
