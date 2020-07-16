package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.leaf.OrderByExpression;

import java.util.ArrayList;
import java.util.List;

public class OrderByClause extends QOMObject {

    private List<OrderByExpression> orderByExpressions;


    public OrderByClause(AQLParser.OrderByClauseContext ctx, Lookup lookup) {
        orderByExpressions = new ArrayList<>();
        ctx.orderByExpr().forEach(orderByExprContext -> orderByExpressions.add(new OrderByExpression(orderByExprContext, lookup)));
    }

    @Override
    public void validate() throws AQLValidationException {
        for (OrderByExpression orderByExpression : orderByExpressions) {
            orderByExpression.validate();
        }
    }

    public OrderByExpression getOrderByExpression(int index) {
        return orderByExpressions.get(index);
    }

    public List<OrderByExpression> getOrderByExpressions() {
        return orderByExpressions;
    }
}
