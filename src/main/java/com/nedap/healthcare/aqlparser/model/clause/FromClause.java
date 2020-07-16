package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.QOMObject;

public class FromClause extends QOMObject {

    private NodeExpression containsExpression;

    public FromClause(AQLParser.FromClauseContext ctx, Lookup lookup) {
        containsExpression = new NodeExpression(ctx.containsExpr(), lookup);

    }

    @Override
    public void validate() throws AQLValidationException {
        containsExpression.validate();
    }

    public NodeExpression getContainsExpression() {
        return containsExpression;
    }
}
