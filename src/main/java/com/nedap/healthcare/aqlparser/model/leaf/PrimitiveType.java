package com.nedap.healthcare.aqlparser.model.leaf;

public enum PrimitiveType {
    STRING,
    INTEGER,
    FLOAT,
    DATE,
    BOOLEAN,
    PARAMETER;

    public boolean isAssignableFrom(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof PrimitiveType)) {
            return false;
        }
        PrimitiveType other = (PrimitiveType) o;

        //Parameter can be any other PrimitiveType
        if (this == PrimitiveType.PARAMETER || other == PrimitiveType.PARAMETER) {
            return true;
        }

        return this == other;
    }
}
