package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;
import org.antlr.v4.runtime.tree.ParseTree;

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
    public void validate() throws AQLValidationException {
        predicateExpression.validate();
    }

    public QOMObject getPredicateExpression() {
        return predicateExpression;
    }
}
