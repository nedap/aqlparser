package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;

public class ArchetypePredicate extends Predicate {

    public ArchetypePredicate(AQLParser.ArchetypePredicateContext ctx, Lookup lookup) {
        predicateExpression = QOMParserUtil.parse(lookup, ctx.archetypePredicateExpr());
    }

}
