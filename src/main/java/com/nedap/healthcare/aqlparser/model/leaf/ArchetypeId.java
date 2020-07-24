package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.archie.aom.ArchetypeHRID;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ArchetypeId extends TerminalNodeLeaf  {

    public ArchetypeId(TerminalNode archetypeId) {
        super(archetypeId);
    }

    @Override
    public void validate() {
        try {
            new ArchetypeHRID(getValue());
        } catch (IllegalArgumentException e) {
            throw new AQLValidationException("ArchetypeId " + getValue() + " could not be validated", e);
        }
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getArchetypeId() {
        return getValue();
    }
}
