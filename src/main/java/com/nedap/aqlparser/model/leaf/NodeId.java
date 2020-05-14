package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NodeId extends QOMObject implements Leaf {

    private final String nodeId;

    public NodeId(TerminalNode nodeId) {
        this(nodeId.getText());
    }

    public NodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public String toString() {
        return nodeId;
    }

    @Override
    public void validate() {

    }
}
