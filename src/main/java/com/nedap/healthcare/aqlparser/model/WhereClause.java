package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;

public class WhereClause extends QOMObject {

    private IdentifiedExpression identifiedExpression;

    public WhereClause(AQLParser.WhereClauseContext ctx, Lookup lookup) {
        identifiedExpression = new IdentifiedExpression(ctx.identifiedExpr(), lookup);
    }

    public IdentifiedExpression getIdentifiedExpression() {
        return identifiedExpression;
    }

    @Override
    public void validate() throws AQLValidationException {
        identifiedExpression.validate();
    }
}
