package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.predicate.NodePredicate;

public class PathPart extends QOMObject {

    private String identifier;

    private NodePredicate nodePredicate;

    public PathPart(AQLParser.PathPartContext ctx) {
        this.identifier = ctx.IDENTIFIER().getText();
        if (ctx.nodePredicate() != null) this.nodePredicate = new NodePredicate(ctx.nodePredicate());
    }

    public NodePredicate getNodePredicate() {
        return nodePredicate;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier + ((nodePredicate != null) ? nodePredicate.toString() : "");
    }

}
