package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ArchetypeId extends QOMObject implements Leaf {

    private final String archetypeId;

    public ArchetypeId(TerminalNode archetypeId) {
        this(archetypeId.getText());
    }

    public ArchetypeId(String archetypeId) {
        this.archetypeId = archetypeId;
    }

    @Override
    public void validate() {
    }
}
