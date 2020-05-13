package com.nedap.aqlparser.model.predicate;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.util.QOMParserUtil;

public class ArchetypePredicate extends Predicate {

    public ArchetypePredicate(AQLParser.ArchetypePredicateContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ArchetypePredicateContext ctx) {
        predicateExpression = QOMParserUtil.parse(ctx);
    }
}
