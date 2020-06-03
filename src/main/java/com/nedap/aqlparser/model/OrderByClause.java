package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.OrderByExpression;

import java.util.ArrayList;
import java.util.List;

public class OrderByClause extends QOMObject {

    private List<OrderByExpression> orderByExpressions;


    public OrderByClause(AQLParser.OrderByClauseContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.OrderByClauseContext ctx) {
        orderByExpressions = new ArrayList<>();
        ctx.orderByExpr().forEach(orderByExprContext -> orderByExpressions.add(new OrderByExpression(orderByExprContext)));
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
