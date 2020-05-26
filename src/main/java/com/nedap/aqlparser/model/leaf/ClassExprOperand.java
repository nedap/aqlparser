package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.QOMObject;
import com.nedap.aqlparser.model.predicate.ArchetypePredicate;
import com.nedap.aqlparser.model.predicate.Predicate;
import com.nedap.aqlparser.util.QOMParserUtil;

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
        className = ctx.IDENTIFIER(0).getText();
        if (ctx.IDENTIFIER(1) != null) variableName = ctx.IDENTIFIER(1).getText();
        if (ctx.standardPredicate() != null) throw new RuntimeException("StandardPredicate not yet implemented");
        if (ctx.archetypePredicate() != null) predicate = new ArchetypePredicate(ctx.archetypePredicate());
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

    }
}
