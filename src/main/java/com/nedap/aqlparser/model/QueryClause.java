package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;

public class QueryClause extends QOMObject{

    private SelectClause selectClause;
    private FromClause fromClause;
    private WhereClause whereClause;
    private OrderByClause orderByClause;

    public QueryClause(AQLParser.QueryContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.QueryContext ctx) {
        selectClause = new SelectClause(ctx.selectClause());
        fromClause = new FromClause(ctx.fromClause());
        if (ctx.whereClause() != null) {
            whereClause = new WhereClause(ctx.whereClause());
        }
        if (ctx.orderByClause() != null) {
            orderByClause = new OrderByClause(ctx.orderByClause());
        }
    }

    public SelectClause getSelectClause() {
        return selectClause;
    }

    public FromClause getFromClause() {
        return fromClause;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
    }

    @Override
    public void validate() throws AQLValidationException {
        selectClause.validate();
        fromClause.validate();
        if (whereClause != null) {
            whereClause.validate();
        }
        if (orderByClause != null) {
            orderByClause.validate();
        }
    }
}
