package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.QOMObject;
import com.nedap.aqlparser.model.predicate.NodePredicate;

public class PathPart extends QOMObject implements Leaf {

    private String identifier;
    private NodePredicate nodePredicate;

    public PathPart(AQLParser.PathPartContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.PathPartContext ctx) {
        identifier = ctx.IDENTIFIER().getText();
        if (ctx.nodePredicate() != null) nodePredicate = new NodePredicate(ctx.nodePredicate());
    }

    @Override
    public String toString() {
        return identifier + ((nodePredicate != null) ? nodePredicate.toString() : "");
    }

    @Override
    public void validate() {

    }
}
