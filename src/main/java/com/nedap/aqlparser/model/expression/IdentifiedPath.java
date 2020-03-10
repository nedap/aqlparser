package com.nedap.aqlparser.model.expression;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.PathPart;
import com.nedap.aqlparser.model.expression.predicate.NodePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IdentifiedPath extends Leaf {

    private String alias;

    private String variableName;

    private NodePredicate predicate;

    private List<PathPart> pathParts;

    private String path;

    public IdentifiedPath(AQLParser.IdentifiedPathContext ctx) {
        variableName = ctx.IDENTIFIER().getText();
        predicate =  (ctx.nodePredicate() != null) ? new NodePredicate(ctx.nodePredicate()) : null;
        pathParts = new ArrayList<>();
        for (AQLParser.PathPartContext pathPartContext : ctx.pathPart()) {
            pathParts.add(new PathPart(pathPartContext));
        }

        path = pathParts.stream().map(PathPart::toString).collect(Collectors.joining("/"));
    }

    public String getAlias() {
        return alias;
    }

    public NodePredicate getPredicate() {
        return predicate;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<PathPart> getPathParts() {
        return pathParts;
    }

    public void setPathParts(List<PathPart> pathParts) {
        this.pathParts = pathParts;
    }

    public String getPath() {
        return path;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }
}
