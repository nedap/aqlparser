package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.archie.aom.ArchetypeHRID;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
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
            //This should not be possible. Already checked in the grammer
            this.addValidationMessage(new AQLValidationMessage("ArchetypeId " + getValue() + " could not be validated"));
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
