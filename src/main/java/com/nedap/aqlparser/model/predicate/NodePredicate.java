package com.nedap.aqlparser.model.predicate;

import com.nedap.aqlparser.AQLParser;

public class NodePredicate extends Predicate {

    public NodePredicate(AQLParser.NodePredicateContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.NodePredicateContext ctx) {
        predicateExpression = new NodePredicateExpression(ctx.nodePredicateExpr());
    }


}
