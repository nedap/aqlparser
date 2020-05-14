package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Parameter extends QOMObject implements Leaf {

    private final String parameter;

    public Parameter(String parameter) {
        this.parameter = parameter;
    }

    public Parameter(TerminalNode parameter) {
        this(parameter.getText());
    }

    @Override
    public String toString() {
        throw new RuntimeException("NYI");
    }

    public Object getValue() {
        throw new RuntimeException("NYI");
    }

    @Override
    public void validate() {
    }
}
