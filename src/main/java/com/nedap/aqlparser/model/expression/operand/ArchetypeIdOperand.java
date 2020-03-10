package com.nedap.aqlparser.model.expression.operand;

import com.nedap.aqlparser.model.expression.OperatorType;

public class ArchetypeIdOperand extends Operand {

    public ArchetypeIdOperand(String archetypeId, OperandType type) {
        super(type, archetypeId);
    }

}
