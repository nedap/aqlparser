package com.nedap.healthcare.aqlparser.model.leaf;

import java.util.HashMap;
import java.util.Map;

public enum OperatorType {

    //Comparison operators
    EQUAL("="),
    GREATER_THAN(">"),
    GREATER_EQUAL_TO(">="),
    SMALLER_THAN("<"),
    SMALLER_EQUAL_TO("<="),
    NOT_EQUAL("!="),
    MATCHES("MATCHES"),

    //Logical operators
    AND("AND"),
    OR("OR"),
    NOT("NOT"),
    EXISTS("EXISTS"),
    CONTAINS("CONTAINS");//This one is not li

    private String type;
    private static final Map<String,OperatorType> lookup = new HashMap<>();

    OperatorType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    static {
        for (OperatorType operatorType : OperatorType.values()) {
            lookup.put(operatorType.getType(),operatorType);
        }
    }

    public static OperatorType get(String type) {
        return lookup.get(type);
    }

    @Override
    public String toString() {
        return type;
    }

}
