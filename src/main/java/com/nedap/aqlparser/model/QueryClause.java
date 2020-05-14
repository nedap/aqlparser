package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;

public class QueryClause extends QOMObject{

    private WhereClause whereClause;

    public QueryClause(AQLParser.QueryContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.QueryContext ctx) {
        whereClause = new WhereClause(ctx.whereClause());
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    @Override
    public void validate() throws AQLValidationException {
        whereClause.validate();
    }
}
