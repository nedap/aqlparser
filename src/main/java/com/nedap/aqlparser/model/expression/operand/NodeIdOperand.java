package com.nedap.aqlparser.model.expression.operand;

public class NodeIdOperand extends Operand {

    public NodeIdOperand(String nodeId) {
        super(OperandType.STRING, nodeId);
    }

}
