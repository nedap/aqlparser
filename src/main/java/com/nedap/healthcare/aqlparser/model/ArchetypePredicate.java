package com.nedap.healthcare.aqlparser.model;

import com.nedap.archie.aom.ArchetypeHRID;
import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLRuntimeException;
import com.nedap.healthcare.aqlparser.model.leaf.ArchetypeId;
import com.nedap.healthcare.aqlparser.model.leaf.PrimitiveOperand;

import java.util.ArrayList;
import java.util.List;

public class ArchetypePredicate extends Predicate {

    private Lookup lookup;

    public ArchetypePredicate(AQLParser.ArchetypePredicateContext ctx, Lookup lookup) {
        super(ctx, lookup);
        this.lookup = lookup;
    }

    @Override
    public List<AQLValidationMessage> validate() {
        List<AQLValidationMessage> messages = new ArrayList<>(getPredicateExpression().validate());
        if (getPredicateExpression() instanceof PrimitiveOperand) {
            PrimitiveOperand parameter = (PrimitiveOperand) getPredicateExpression();
            if (!(parameter.getValue() instanceof String)) {
                messages.add(new AQLValidationMessage("Expected Parameter " + lookup.getParameterKey(parameter) + " in " +
                        "ArchetypePredicate to be of type STRING"));
            } else {
                try {
                    new ArchetypeHRID((String) parameter.getValue());
                } catch (IllegalArgumentException e) {
                    messages.add(new AQLValidationMessage(parameter.getValue().toString() + " is not a valid archetype human readable id."));
                }
            }
        }
        return messages;
    }

    public String getArchetypeId() {
        if (getPredicateExpression() instanceof ArchetypeId) {
            return ((ArchetypeId) getPredicateExpression()).getArchetypeId();
        } else if (getPredicateExpression() instanceof PrimitiveOperand) {
            return ((PrimitiveOperand) getPredicateExpression()).getValue().toString();
        } else {
            throw new AQLRuntimeException("Must not be reached!");
        }
    }
}
