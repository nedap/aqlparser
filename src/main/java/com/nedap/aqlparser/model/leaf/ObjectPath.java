package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.QOMObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectPath extends QOMObject implements Leaf {

    private List<PathPart> pathParts;

    public ObjectPath(AQLParser.ObjectPathContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ObjectPathContext ctx) {
        pathParts = new ArrayList<>();
        ctx.pathPart().forEach(pathPartContext -> pathParts.add(new PathPart(pathPartContext)));
    }

    @Override
    public String toString() {
        //ToDo: Add function to remove aql identifier! Will fail for certain paths
        return '/' + pathParts.subList(1,pathParts.size()).stream().map(PathPart::toString).collect(Collectors.joining("/"));
    }

    @Override
    public void validate() {
    }
}
