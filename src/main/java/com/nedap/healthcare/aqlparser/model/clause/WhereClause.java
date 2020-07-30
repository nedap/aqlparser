package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.util.List;

public class WhereClause extends QOMObject {

    private NodeExpression identifiedExpression;

    public WhereClause(AQLParser.WhereClauseContext ctx, Lookup lookup) {
        identifiedExpression = new NodeExpression(ctx.identifiedExpr(), lookup);
    }

    public NodeExpression getIdentifiedExpression() {
        return identifiedExpression;
    }

    @Override
    public List<AQLValidationMessage> validate() {
        return identifiedExpression.validate();
    }
}
