package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

public class URIValue extends QOMObject implements Leaf {

    private final String value;

    public URIValue(TerminalNode terminalNode) {
        this(terminalNode.getText());
    }

    public URIValue(String value) {
        this.value = value;
    }

    @Override
    public void validate() {

    }

    public String getValue() {
        return value;
    }
}
