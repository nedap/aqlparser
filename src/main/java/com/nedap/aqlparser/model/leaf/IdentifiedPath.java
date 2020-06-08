package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.Lookup;
import com.nedap.aqlparser.model.QOMObject;
import com.nedap.aqlparser.model.predicate.NodePredicate;

public class IdentifiedPath extends QOMObject implements Leaf {

    private String variableName;

    private NodePredicate nodePredicate;

    private ObjectPath objectPath;

    public IdentifiedPath(AQLParser.IdentifiedPathContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedPathContext ctx) {
        variableName = ctx.IDENTIFIER().getText();
        if (ctx.nodePredicate() != null) nodePredicate = new NodePredicate(ctx.nodePredicate());
        if (ctx.objectPath() != null) objectPath = new ObjectPath(ctx.objectPath());
    }

    @Override
    public void validate() throws AQLValidationException {
        if (nodePredicate != null) nodePredicate.validate();
        if (objectPath != null) objectPath.validate();
    }

    public ObjectPath getObjectPath() {
        if (objectPath == null) {
            IdentifiedPath identifiedPath = Lookup.getIdentifiedPath(variableName);
            if (identifiedPath != null) {
                return identifiedPath.getObjectPath();
            }
        }
        return objectPath;
    }

    public NodePredicate getNodePredicate() {
        return nodePredicate;
    }

    public String getVariableName() {
        return variableName;
    }

    public ClassExprOperand getClassExprOperand() {
        return Lookup.getClassExprOperand(getVariableName());
    }

}
