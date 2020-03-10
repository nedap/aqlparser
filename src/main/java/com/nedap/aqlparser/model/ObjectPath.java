package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectPath extends Leaf {

    List<PathPart> pathParts;

    public ObjectPath(AQLParser.ObjectPathContext ctx) {
        pathParts = new ArrayList<>();
        for (AQLParser.PathPartContext pathPartContext : ctx.pathPart()) {
            pathParts.add(new PathPart(pathPartContext));
        }
    }

    public List<PathPart> getPathParts() {
        return pathParts;
    }

    @Override
    public String toString() {
        return pathParts.stream().map(PathPart::toString).collect(Collectors.joining("/"));
    }

}
