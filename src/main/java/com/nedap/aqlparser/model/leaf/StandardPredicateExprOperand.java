package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.NodeExpression;

public class StandardPredicateExprOperand extends NodeExpression implements Leaf {

    public StandardPredicateExprOperand(AQLParser.StandardPredicateExprOperandContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.StandardPredicateExprOperandContext ctx) {
        setObject(ctx.COMPARABLEOPERATOR());
        addChildren(ctx.predicateOperand(0),ctx.predicateOperand(1));
    }

}
