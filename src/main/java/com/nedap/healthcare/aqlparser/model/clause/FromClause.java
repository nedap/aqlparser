package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.util.List;

public class FromClause extends QOMObject {

    private NodeExpression containsExpression;

    public FromClause(AQLParser.FromClauseContext ctx, Lookup lookup) {
        containsExpression = new NodeExpression(ctx.containsExpr(), lookup);

    }

    @Override
    public List<AQLValidationMessage> validate() {
        return containsExpression.validate();
    }

    public NodeExpression getContainsExpression() {
        return containsExpression;
    }
}
