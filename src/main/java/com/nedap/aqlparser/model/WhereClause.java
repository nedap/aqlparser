package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.IdentifiedExpression;

public class WhereClause extends QOMObject {

    IdentifiedExpression identifiedExpression;

    public WhereClause(AQLParser.WhereClauseContext ctx) {
        identifiedExpression = new IdentifiedExpression(ctx.identifiedExpr());
    }

}
