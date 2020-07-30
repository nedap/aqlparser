package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.util.ArrayList;
import java.util.List;

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
    public List<AQLValidationMessage> validate() {
        List<AQLValidationMessage> messages = new ArrayList<>();
        messages.addAll(selectClause.validate());
        messages.addAll(fromClause.validate());
        if (whereClause != null) {
            messages.addAll(whereClause.validate());
        }
        if (orderByClause != null) {
            messages.addAll(orderByClause.validate());
        }
        return messages;
    }
}
