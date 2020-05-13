package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.leaf.*;
import com.nedap.aqlparser.model.NodeExpression;
import com.nedap.aqlparser.util.QOMParserUtil;

public class NodePredicateExprOperand extends NodeExpression implements Leaf {

    public NodePredicateExprOperand(AQLParser.NodePredicateExprOperandContext ctx){

        if (!ctx.predicateOperand().isEmpty()) {
            setObject(QOMParserUtil.parse(ctx.COMPARABLEOPERATOR(),ctx.MATCHES()).get(0));
            addChildren(QOMParserUtil.parse(ctx.predicateOperand(0),ctx.predicateOperand(1),ctx.REGEXPATTERN()));
        } else if (ctx.COMMA() != null) {
            setObject(new Operator(OperatorType.AND));
            addChildren(QOMParserUtil.parse(ctx.NODEID(),
                    ctx.ARCHETYPEID(),
                    ctx.PARAMETER(0),
                    ctx.STRING(),
                    ctx.PARAMETER(1)));
        } else {
            setObject(QOMParserUtil.parse(
                    ctx.NODEID(),
                    ctx.ARCHETYPEID(),
                    ctx.PARAMETER(0)).get(0));
        }

    }

}
