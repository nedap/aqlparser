package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;

public class Query extends QOMObject {

    SelectClause selectClause;
    FromClause fromClause;
    WhereClause whereClause;

    public Query(AQLParser.QueryContext ctx) {
        selectClause = new SelectClause(ctx.selectClause());
        fromClause = new FromClause(ctx.fromClause());
        if (ctx.whereClause() != null) whereClause = new WhereClause(ctx.whereClause());
    }

    public FromClause getFromClause() {
        return fromClause;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public SelectClause getSelectClause() {
        return selectClause;
    }

}
