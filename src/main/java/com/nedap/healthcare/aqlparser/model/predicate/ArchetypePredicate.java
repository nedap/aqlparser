package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;

public class ArchetypePredicate extends Predicate {

    public ArchetypePredicate(AQLParser.ArchetypePredicateContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ArchetypePredicateContext ctx) {
        predicateExpression = QOMParserUtil.parse(ctx.archetypePredicateExpr());
    }
}
