package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.ClassExpression;
import com.nedap.aqlparser.model.expression.ContainsExpression;

public class Containment extends QOMObject {

    private ClassExpression fromClass;

    private ContainsExpression contains;

    public Containment(AQLParser.ContainsContext ctx) {
        fromClass = new ClassExpression(ctx.classExpr());
        if (ctx.containsExpression() != null) contains = new ContainsExpression(ctx.containsExpression());
    }

    public Containment(AQLParser.ContainsExpressionContext ctx) {
        fromClass = null;
        contains = new ContainsExpression(ctx);
    }

    public ClassExpression getFromClass() {
        return fromClass;
    }

    public ContainsExpression getContains() {
        return contains;
    }


}
