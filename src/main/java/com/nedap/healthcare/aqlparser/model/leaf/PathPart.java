package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.Predicate;

public class PathPart extends QOMObject {

    private String identifier;
    private Predicate nodePredicate;

    public PathPart(AQLParser.PathPartContext ctx, Lookup lookup) {
        identifier = ctx.IDENTIFIER().getText();
        if (ctx.nodePredicate() != null) nodePredicate = new Predicate(ctx.nodePredicate(), lookup);
    }

    @Override
    public String toString() {
        return identifier + ((nodePredicate != null) ? nodePredicate.toString() : "");
    }

    @Override
    public void validate() {

    }

    public String getIdentifier() {
        return identifier;
    }
}
