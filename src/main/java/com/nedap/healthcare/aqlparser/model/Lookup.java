package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.healthcare.aqlparser.model.leaf.IdentifiedPath;
import com.nedap.healthcare.aqlparser.model.leaf.PrimitiveOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;

import java.util.HashMap;
import java.util.Map;

public class Lookup {

    private Map<String, IdentifiedPath> aliases;
    private Map<String, ClassExprOperand> variables;
    private Map<String, PrimitiveOperand> parameter;

    public Lookup() {
        aliases = new HashMap<>();
        variables = new HashMap<>();
        parameter = new HashMap<>();
    }

    public void addAlias(String alias, IdentifiedPath identifiedPath) {
        aliases.put(alias,identifiedPath);
    }

    public IdentifiedPath getIdentifiedPath(String alias) {
        return aliases.get(alias);
    }

    public void addVariable(String variable, ClassExprOperand classExprOperand) {
        variables.put(variable,classExprOperand);
    }

    public ClassExprOperand getClassExprOperand(String variable) {
        return variables.get(variable);
    }

    public void addParameter(String parameter, Object value) {
        try {
            PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(value.toString(),"primitiveOperand", this);
            addParameter(parameter,primitiveOperand);
        } catch (AQLValidationException e) {
            throw new RuntimeException("Could not add parameter ", e);
        }
    }

    public void addParameter(String param, PrimitiveOperand primitiveOperand) {
        parameter.put(param,primitiveOperand);
    }

    public PrimitiveOperand getParameter(String param) {
        return parameter.get(param);
    }

}
