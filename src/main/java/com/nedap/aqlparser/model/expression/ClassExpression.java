package com.nedap.aqlparser.model.expression;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.predicate.ArchetypePredicate;
import com.nedap.aqlparser.model.expression.predicate.Predicate;
import com.nedap.aqlparser.model.expression.predicate.StandardPredicate;

public class ClassExpression extends Leaf {

    String className;

    String variableName;

    Predicate predicate;

    public ClassExpression(AQLParser.ClassExprContext ctx) {
        className = ctx.IDENTIFIER(0).getText();
        if (ctx.IDENTIFIER().size() == 2) variableName = ctx.IDENTIFIER().get(1).getText();
        if (ctx.archetypePredicate() != null) {
            predicate = new ArchetypePredicate(ctx.archetypePredicate());
        } else if (ctx.standardPredicate() != null) {
            predicate = new StandardPredicate(ctx.standardPredicate());
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
}
