package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.archie.aom.ArchetypeHRID;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ArchetypeId extends TerminalNodeLeaf  {

    public ArchetypeId(TerminalNode archetypeId) {
        super(archetypeId);
    }

    @Override
    public void validate() {
        new ArchetypeHRID(getValue());
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getArchetypeId() {
        return getValue();
    }
}
