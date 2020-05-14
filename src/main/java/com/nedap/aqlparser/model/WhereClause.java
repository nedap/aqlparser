package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;

public class WhereClause extends QOMObject {

    private IdentifiedExpression identifiedExpression;

    public WhereClause(AQLParser.WhereClauseContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.WhereClauseContext ctx) {
        identifiedExpression = new IdentifiedExpression(ctx.identifiedExpr());
    }

    public IdentifiedExpression getIdentifiedExpression() {
        return identifiedExpression;
    }

    @Override
    public void validate() throws AQLValidationException {
        identifiedExpression.validate();
    }
}
