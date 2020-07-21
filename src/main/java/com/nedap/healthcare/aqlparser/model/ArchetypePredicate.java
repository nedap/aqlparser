package com.nedap.healthcare.aqlparser.model;

import com.nedap.archie.aom.ArchetypeHRID;
import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLRuntimeException;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.ArchetypeId;
import com.nedap.healthcare.aqlparser.model.leaf.PrimitiveOperand;

public class ArchetypePredicate extends Predicate {

    private Lookup lookup;

    public ArchetypePredicate(AQLParser.ArchetypePredicateContext ctx, Lookup lookup) {
        super(ctx, lookup);
        this.lookup = lookup;
    }

    @Override
    public void validate() throws AQLValidationException {
        getPredicateExpression().validate();
        if (getPredicateExpression() instanceof PrimitiveOperand) {
            PrimitiveOperand parameter = (PrimitiveOperand) getPredicateExpression();
            if (!(parameter.getValue() instanceof String)) {
                throw new AQLValidationException("Expected Parameter " + lookup.getParameterKey(parameter) + " in " +
                        "ArchetypePredicate to be of type STRING");
            }
            try {
                new ArchetypeHRID((String) parameter.getValue());
            } catch (IllegalArgumentException e) {
                throw new AQLValidationException(parameter.getValue().toString() + " is not a valid archetype human readable id");
            }
        }
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
