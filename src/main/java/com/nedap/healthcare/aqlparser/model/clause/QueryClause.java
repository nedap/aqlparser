package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;

public class QueryClause extends QOMObject {

    private SelectClause selectClause;
    private FromClause fromClause;
    private WhereClause whereClause;
    private OrderByClause orderByClause;

    public QueryClause(AQLParser.QueryClauseContext ctx, Lookup lookup) {
        selectClause = new SelectClause(ctx.selectClause(), lookup);
        fromClause = new FromClause(ctx.fromClause(), lookup);
        if (ctx.whereClause() != null) {
            whereClause = new WhereClause(ctx.whereClause(), lookup);
        }
        if (ctx.orderByClause() != null) {
            orderByClause = new OrderByClause(ctx.orderByClause(), lookup);
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
