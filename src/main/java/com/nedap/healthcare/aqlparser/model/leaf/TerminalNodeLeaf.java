package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class TerminalNodeLeaf extends QOMObject {

    private final String value;

    public TerminalNodeLeaf(TerminalNode terminalNode) {
        this.value = terminalNode.getText();
    }

    @Override
    public List<AQLValidationMessage> validate() {
        return new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
