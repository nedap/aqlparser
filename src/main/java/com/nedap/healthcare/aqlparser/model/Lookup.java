package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.healthcare.aqlparser.model.leaf.IdentifiedPath;
import com.nedap.healthcare.aqlparser.model.leaf.PrimitiveOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;

import java.util.HashMap;
import java.util.Map;

public class Lookup {

    private static Map<String, IdentifiedPath> aliases;
    private static Map<String, ClassExprOperand> variables;
    private static Map<String, PrimitiveOperand> parameter;

    static {
        aliases = new HashMap<>();
        variables = new HashMap<>();
        parameter = new HashMap<>();
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

    public static void addParameter(String parameter, Object value) {
        try {
            PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(value.toString(),"primitiveOperand");
            addParameter(parameter,primitiveOperand);
        } catch (AQLValidationException e) {
            throw new RuntimeException("Could not add parameter ", e);
        }
    }

    public static void addParameter(String param, PrimitiveOperand primitiveOperand) {
        parameter.put(param,primitiveOperand);
    }

    public static PrimitiveOperand getParameter(String param) {
        return parameter.get(param);
    }
}
