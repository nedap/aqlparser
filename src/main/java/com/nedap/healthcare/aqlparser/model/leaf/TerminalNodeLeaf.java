package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TerminalNodeLeaf extends QOMObject {

    private final String value;

    public TerminalNodeLeaf(TerminalNode terminalNode) {
        this.value = terminalNode.getText();
    }

    @Override
    public void validate() throws AQLValidationException {
        //ToDo
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
