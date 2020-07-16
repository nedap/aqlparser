package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectPath extends QOMObject {

    private List<PathPart> pathParts;

    public ObjectPath(AQLParser.ObjectPathContext ctx, Lookup lookup) {
        pathParts = new ArrayList<>();
        ctx.pathPart().forEach(pathPartContext -> pathParts.add(new PathPart(pathPartContext, lookup)));
    }

    @Override
    public String toString() {
        return '/' + pathParts.stream().map(PathPart::toString).collect(Collectors.joining("/"));
    }

    @Override
    public void validate() {
    }

    /**
     * @return true if the RmObject that ObjectPath is referring to is a COMPOSITION
     */
    public Boolean isCompositionPath() {
        String identifier = pathParts.get(0).getIdentifier().toLowerCase();
        //Check if first identifier equals
        switch (identifier) {
            case "language":
            case "territory":
            case "category":
            case "context":
            case "composer":
            case "content":
                return true;
            default:
                return false;
        }
    }
}
