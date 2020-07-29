package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;

public class Predicate extends QOMObject {

    private QOMObject predicateExpression;

    public Predicate(AQLParser.NodePredicateContext ctx, Lookup lookup) {
        predicateExpression = new NodeExpression(ctx.nodePredicateExpr(), lookup);
    }

    public Predicate(AQLParser.ArchetypePredicateContext ctx, Lookup lookup) {
        predicateExpression = QOMParserUtil.parse(lookup, ctx.archetypePredicateExpr());
    }

    public Predicate(AQLParser.StandardPredicateContext ctx, Lookup lookup) {
        predicateExpression = new NodeExpression(ctx.standardPredicateExpr(), lookup);
    }

    @Override
    public String toString() {
        return "[" + predicateExpression.toString() + "]";
    }

    @Override
    public void validate() {
        predicateExpression.validate();
    }

    public QOMObject getPredicateExpression() {
        return predicateExpression;
    }
}
