package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.aqlparser.model.leaf.IdentifiedPath;

import java.util.HashMap;
import java.util.Map;

public class Lookup {

    private static Map<String, IdentifiedPath> aliases;
    private static Map<String, ClassExprOperand> variables;

    static {
        aliases = new HashMap<>();
        variables = new HashMap<>();
    }

    public static void addAlias(String alias, IdentifiedPath identifiedPath) {
        aliases.put(alias,identifiedPath);
    }

    public static IdentifiedPath getIdentifiedPath(String alias) {
        return aliases.get(alias);
    }

    public static void addVariable(String variable, ClassExprOperand classExprOperand) {
        variables.put(variable,classExprOperand);
    }

    public static ClassExprOperand getClassExprOperand(String variable) {
        return variables.get(variable);
    }

}
