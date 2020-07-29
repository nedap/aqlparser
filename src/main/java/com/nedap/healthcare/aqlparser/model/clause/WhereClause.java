package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.QOMObject;

public class WhereClause extends QOMObject {

    private NodeExpression identifiedExpression;

    public WhereClause(AQLParser.WhereClauseContext ctx, Lookup lookup) {
        identifiedExpression = new NodeExpression(ctx.identifiedExpr(), lookup);
    }

    public NodeExpression getIdentifiedExpression() {
        return identifiedExpression;
    }

    @Override
    public void validate() {
        identifiedExpression.validate();
    }
}
