package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.QOMObject;


public class PrimitiveOperand extends QOMObject implements Leaf {

    private PrimitiveType type;

    private Object value;

    public PrimitiveOperand(AQLParser.PrimitiveOperandContext ctx) {
        initialize(ctx);
    }

    public PrimitiveOperand(PrimitiveType type, String value) {
        this.type = type;
        this.value = castValueToType(value);
    }

    private void initialize(AQLParser.PrimitiveOperandContext ctx) {
        if (ctx.STRING() != null) {
            type =  PrimitiveType.STRING;
            value = castValueToType(ctx.STRING().getText());
        } else if (ctx.INTEGER() != null) {
            type =  PrimitiveType.INTEGER;
            value = castValueToType(ctx.INTEGER().getText());
        } else if (ctx.FLOAT() != null) {
            type =  PrimitiveType.FLOAT;
            value = castValueToType(ctx.FLOAT().getText());
        } else if (ctx.DATE() != null) {
            type =  PrimitiveType.DATE;
            value = castValueToType(ctx.DATE().getText());
        } else if (ctx.BOOLEAN() != null) {
            type = PrimitiveType.BOOLEAN;
            value = castValueToType(ctx.BOOLEAN().getText());
        } else if (ctx.PARAMETER() != null) {
            type = PrimitiveType.PARAMETER;
            value = castValueToType(ctx.PARAMETER().getText());
        } else {
            throw new RuntimeException("Unknown operand type");
        }
    }

    private Object castValueToType(Object value) {
        if (type == PrimitiveType.STRING) {
            String result = value.toString();
            if (result.startsWith("'") || result.startsWith("\"")) {
                result = result.substring(1,result.length() - 1);
            }
            return result;
        } else if (type == PrimitiveType.INTEGER) {
            return Integer.parseInt((String) value);
        } else if (type == PrimitiveType.FLOAT) {
            return Float.parseFloat((String) value);
        } else if (type == PrimitiveType.DATE) {
            throw new RuntimeException("NYI");
        } else if (type == PrimitiveType.BOOLEAN) {
            return Boolean.parseBoolean((String) value);
        } else if (type == PrimitiveType.PARAMETER) {
            return value.toString();
        } else {
            throw new RuntimeException("Unknown operand type");
        }
    }

    public PrimitiveType getType() {
        return type;
    }

    public Object getValue() {
        //ToDo:
        if (type.equals(PrimitiveType.PARAMETER)) throw new RuntimeException("Parameters not yet supported");
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public void validate() {

    }

}
