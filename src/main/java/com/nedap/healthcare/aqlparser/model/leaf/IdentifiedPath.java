package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * In AQL, an IdentifiedPath is the association of a variable reference (the identifier; see above) and an archetype
 * path and/or predicate. Except for the FROM clause, an identified path may appear in any clause of an AQL statement.
 * For example, it can be used to indicate the data to be returned in a SELECT clause, or the data item on which query
 * criteria are applied in a WHERE clause.
 *
 * An IdentifiedPath can take any of the following forms:
 *
 * - a variable name defined in the FROM clause followed by an archetype path, which specifies a data item at that path
 *   within the object, as follows:
 *
 *      o/data[at0001]/.../data[at0003]/items[at0004]/value/value
 *
 * - a variable name followed by a predicate, which specifies an object that satisfies the predicate, as follows:
 *
 *      o[name/value=$nameValue]
 *
 * - a variable name followed by a predicate and an archetype path, which specifies a data item at a path within an
 *   object satisfying the predicate, as follows:
 *
 *      o[name/value=$nameValue]/data[at0001]/.../data[at0003]/items[at0004]/value/value
 *
 * - an alias, which is resolved using the Lookup class. Note that this case is not specified in the AQL specifications.
 *
 *
 *  cf. https://specifications.openehr.org/releases/QUERY/latest/AQL.html#_aql_identified_paths
 */
public class IdentifiedPath extends QOMObject {

    private String variableName;

    private Predicate nodePredicate;

    private ObjectPath objectPath;

    private Lookup lookup;

    public IdentifiedPath(AQLParser.IdentifiedPathContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedPathContext ctx) {
        variableName = ctx.IDENTIFIER().getText();
        if (ctx.nodePredicate() != null) nodePredicate = new Predicate(ctx.nodePredicate(), lookup);
        if (ctx.objectPath() != null) objectPath = new ObjectPath(ctx.objectPath(), lookup);
    }

    @Override
    public List<AQLValidationMessage> validate() {
        List<AQLValidationMessage> messages = new ArrayList<>();
        if (nodePredicate != null) messages.addAll(nodePredicate.validate());
        if (objectPath != null) messages.addAll(objectPath.validate());
        ClassExprOperand classExprOperand = lookup.getClassExprOperand(variableName);
        if (classExprOperand == null) {
            messages.add(new AQLValidationMessage(this.getClass(), "Invalid variable: " + variableName));
        }
        return messages;
    }

    public ObjectPath getObjectPath() {
        if (objectPath == null) {
            //Check if variableName is alias and if so, return corresponding path
            IdentifiedPath identifiedPath = lookup.getIdentifiedPath(variableName);
            if (identifiedPath != null) {
                return identifiedPath.getObjectPath();
            }
        }
        return objectPath;
    }

    public Predicate getNodePredicate() {
        return nodePredicate;
    }

    public String getVariableName() {
        return variableName;
    }

}
