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
        ClassExprOperand classExprOperand = variables.get(variable);
        if (classExprOperand == null) {
            //Variable could be alias
            IdentifiedPath identifiedPath = aliases.get(variable);
            if (identifiedPath != null) {
                classExprOperand = variables.get(identifiedPath.getVariableName());
            }
        }
        return classExprOperand;
    }

    public void addParameter(String parameter, Object value) throws AQLValidationException {
            PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(value.toString(),"primitiveOperand", this);
            addParameter(parameter,primitiveOperand);
    }

    public void addParameter(String param, PrimitiveOperand primitiveOperand) {
        parameter.put(param,primitiveOperand);
    }

    public PrimitiveOperand getParameter(String param) {
        return parameter.get(param);
    }

    public String getParameterKey(PrimitiveOperand primitiveOperand) {
        return parameter.entrySet().stream().filter(entry -> primitiveOperand.getValue().equals(entry.getValue()))
    }

}
