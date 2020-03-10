package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;

public class FromClause extends QOMObject {

    private Containment containment;

    public FromClause(AQLParser.FromClauseContext ctx) {
        if (ctx.containsExpression() != null) {
           containment = new Containment(ctx.containsExpression());
        } else if (ctx.contains() != null) {
            containment = new Containment(ctx.contains());
        } else {
            throw new RuntimeException("Must not be reached!");
        }
    }

    public Containment getContainment() {
        return containment;
    }


}
