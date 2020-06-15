package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.predicate.ArchetypePredicate;
import com.nedap.healthcare.aqlparser.model.predicate.Predicate;
import com.nedap.healthcare.aqlparser.model.predicate.StandardPredicate;

/**
 * Class expressions syntax include three parts. A class expression must have part one and at least one of part two or
 * part three.
 *
 * - part one (mandatory): openEHR RM class name, such as EHR, COMPOSITION, OBSERVATION etc.
 * - part two (optional): AQL variable name
 * - part three (optional): a standard predicate or an archetype predicate.
 */
public class ClassExprOperand extends QOMObject implements Leaf {

    private String className;
    private String variableName;
    private Predicate predicate;

    public ClassExprOperand(AQLParser.ClassExprOperandContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ClassExprOperandContext ctx) {
        className = ctx.IDENTIFIER(0).getText().toUpperCase();
        if (ctx.standardPredicate() != null) predicate = new StandardPredicate(ctx.standardPredicate());
        if (ctx.archetypePredicate() != null) predicate = new ArchetypePredicate(ctx.archetypePredicate());
        if (ctx.IDENTIFIER(1) != null) {
            variableName = ctx.IDENTIFIER(1).getText();
            Lookup.addVariable(variableName,this);
        }
    }

    public String getClassName() {
        return className;
    }

    public String getVariableName() {
        return variableName;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public void validate() throws AQLValidationException {
        if (predicate != null) {
            predicate.validate();
        }
    }
}
