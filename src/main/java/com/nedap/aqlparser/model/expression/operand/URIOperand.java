package com.nedap.aqlparser.model.expression.operand;

public class URIOperand extends Operand {

    public URIOperand(String uri) {
        super(OperandType.STRING, uri);
    }

}
