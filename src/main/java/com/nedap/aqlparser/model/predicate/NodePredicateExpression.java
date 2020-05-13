package com.nedap.aqlparser.model.predicate;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.NodeExpression;
import com.nedap.aqlparser.model.leaf.NodePredicateExprOperand;
import com.nedap.aqlparser.util.QOMParserUtil;

public class NodePredicateExpression extends NodeExpression {

    public NodePredicateExpression(AQLParser.NodePredicateExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.NodePredicateExprContext ctx) {
        if (ctx.OPEN() != null) initialize(ctx.nodePredicateExpr(0));
        setObject(ctx.AND(),ctx.XOR(),ctx.OR(),ctx.nodePredicateExprOperand());
        addChildren(ctx.nodePredicateExpr(0),ctx.nodePredicateExpr(1));
    }


}
