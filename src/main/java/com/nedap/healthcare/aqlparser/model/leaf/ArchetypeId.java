package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.archie.aom.ArchetypeHRID;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ArchetypeId extends TerminalNodeLeaf  {

    public ArchetypeId(TerminalNode archetypeId) {
        super(archetypeId);
    }

    @Override
    public List<AQLValidationMessage> validate() {
        List<AQLValidationMessage> messages = new ArrayList<>();
        try {
            new ArchetypeHRID(getValue());
        } catch (IllegalArgumentException e) {
            //This should not be possible. Already checked in the grammer
            messages.add(new AQLValidationMessage(this.getClass(),  "ArchetypeId " + getValue() + " could not be validated"));
        }
        return messages;
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getArchetypeId() {
        return getValue();
    }
}
