package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.Predicate;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;

/**
 * Class expressions syntax include three parts. A class expression must have part one and at least one of part two or
 * part three.
 *
 * - part one (mandatory): openEHR RM class name, such as EHR, COMPOSITION, OBSERVATION etc.
 * - part two (optional): AQL variable name
 * - part three (optional): a standard predicate or an archetype predicate.
 */
public class ClassExprOperand extends QOMObject {

    private String className;
    private String variableName;
    private Predicate predicate;
    private Lookup lookup;

    public ClassExprOperand(AQLParser.ClassExprOperandContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    private void initialize(AQLParser.ClassExprOperandContext ctx) {
        className = ctx.IDENTIFIER(0).getText().toUpperCase();
        if (ctx.standardPredicate() != null || ctx.archetypePredicate() != null) {
            predicate = (Predicate) QOMParserUtil.parse(lookup, ctx.standardPredicate(), ctx.archetypePredicate()).get(0);
        }
        if (ctx.IDENTIFIER(1) != null) {
            variableName = ctx.IDENTIFIER(1).getText();
            lookup.addVariable(variableName,this);
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
