package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.clause.OrderDirection;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.util.List;

public class OrderByExpression extends QOMObject {

    private IdentifiedPath identifiedPath;
    private OrderDirection order;

    public OrderByExpression(AQLParser.OrderByExprContext ctx, Lookup lookup) {
        identifiedPath = new IdentifiedPath(ctx.identifiedPath(), lookup);
        order = OrderDirection.DESCENDING;
        if (ctx.ASC() != null || ctx.ASCENDING() != null) order = OrderDirection.ASCENDING;
    }

    @Override
    public List<AQLValidationMessage> validate() {
        return identifiedPath.validate();
    }

    public IdentifiedPath getIdentifiedPath() {
        return identifiedPath;
    }

    public OrderDirection getOrder() {
        return order;
    }
}
