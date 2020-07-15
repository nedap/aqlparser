package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.OrderDirection;
import com.nedap.healthcare.aqlparser.model.QOMObject;

public class OrderByExpression extends QOMObject implements Leaf {

    private IdentifiedPath identifiedPath;
    private OrderDirection order;

    public OrderByExpression(AQLParser.OrderByExprContext ctx, Lookup lookup) {
        identifiedPath = new IdentifiedPath(ctx.identifiedPath(), lookup);
        order = OrderDirection.DESCENDING;
        if (ctx.ASC() != null || ctx.ASCENDING() != null) order = OrderDirection.ASCENDING;
    }

    @Override
    public void validate() throws AQLValidationException {

    }

    public IdentifiedPath getIdentifiedPath() {
        return identifiedPath;
    }

    public OrderDirection getOrder() {
        return order;
    }
}
