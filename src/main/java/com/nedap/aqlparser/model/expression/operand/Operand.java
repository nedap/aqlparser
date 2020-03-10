package com.nedap.aqlparser.model.expression.operand;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.Leaf;

public class Operand extends Leaf {

    private OperandType type;

    private Object value;

    public Operand(OperandType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Operand(AQLParser.OperandContext ctx) {
        value = ctx.getText();
        if (ctx.STRING() != null) {
            type =  OperandType.STRING;
        } else if (ctx.INTEGER() != null) {
            type =  OperandType.INTEGER;
            value = Integer.parseInt((String) value);
        } else if (ctx.FLOAT() != null) {
            type =  OperandType.FLOAT;
            value = Float.parseFloat((String) value);
        } else if (ctx.DATE() != null) {
            type =  OperandType.DATE;
        } else if (ctx.PARAMETER() != null) {
            type =  OperandType.PARAMETER;
        } else if (ctx.BOOLEAN() != null) {
            type = OperandType.BOOLEAN;
            value = Boolean.parseBoolean((String) value);
        } else {
            throw new RuntimeException("Unknown operand type");
        }
    }

    public Object getValue() {
        return value;
    }

    public OperandType getType() {
        return type;
    }

    @Override
    public String toString() {
        if (type == OperandType.PARAMETER) {
            throw new RuntimeException("Cannot resolve parameter -- NYI");
        }
        return value.toString();
    }

}
