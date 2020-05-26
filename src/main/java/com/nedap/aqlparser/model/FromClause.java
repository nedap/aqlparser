package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;

public class FromClause extends QOMObject {

    private ContainsExpression containsExpression;

    public FromClause(AQLParser.FromClauseContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.FromClauseContext ctx) {
        containsExpression = new ContainsExpression(ctx.containsExpr());
    }

    @Override
    public void validate() throws AQLValidationException {
        containsExpression.validate();
    }

    public ContainsExpression getContainsExpression() {
        return containsExpression;
    }
}
