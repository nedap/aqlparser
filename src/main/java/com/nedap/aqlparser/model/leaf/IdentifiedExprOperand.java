package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.NodeExpression;

public class IdentifiedExprOperand extends NodeExpression implements Leaf {

    public IdentifiedExprOperand(AQLParser.IdentifiedExprOperandContext ctx){
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedExprOperandContext ctx) {
        setObject(ctx.COMPARABLEOPERATOR(),ctx.MATCHES());
        addChildren(ctx.predicateOperand(0),ctx.predicateOperand(1),ctx.matchesOperand());
    }
}
