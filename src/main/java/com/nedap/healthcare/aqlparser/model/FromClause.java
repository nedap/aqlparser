package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;

public class FromClause extends QOMObject {

    private ContainsExpression containsExpression;

    public FromClause(AQLParser.FromClauseContext ctx, Lookup lookup) {
        containsExpression = new ContainsExpression(ctx.containsExpr(), lookup);

    }

    @Override
    public void validate() throws AQLValidationException {
        containsExpression.validate();
    }

    public ContainsExpression getContainsExpression() {
        return containsExpression;
    }
}
