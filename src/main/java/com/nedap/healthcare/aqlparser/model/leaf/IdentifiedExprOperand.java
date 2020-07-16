package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.QOMObject;

/**
 * An identified expression specifies matching criteria in the WHERE clause and comes in two forms. The first form is
 * an expression formed by a unary operator, such as NOT or EXISTS, described earlier. The second is a binary operator
 * expression, formed as follows:
 *
 * 1) left operand: an identified path;
 * 2) operator: a comparison operator;
 * 3) right operand: one of:
 *      - a value criterion, normally of a primitive type, such as String, Integer, Boolean, Double, or Float;
 *        if a String value, single or double quotation marks are required; OR
 *      - a replaceable parameter (identified with the '$' symbol); OR
 *      - an identified path.
 */
public class IdentifiedExprOperand extends NodeExpression {


    public IdentifiedExprOperand(AQLParser.IdentifiedExprOperandContext ctx, Lookup lookup){
        super(ctx, lookup);
    }

    @Override
    public void validate() throws AQLValidationException {
        IdentifiedPath identifiedPath = getIdentifiedPath();
        if (identifiedPath == null) {
            throw new AQLValidationException("Failed to set identified Path");
        }
    }

    public IdentifiedPath getIdentifiedPath() {
        if (!hasChildren()){
            return getIdentifiedPath(getObject());
        } else {
            return getIdentifiedPath(getChildren(0).getObject());
        }
    }

    private IdentifiedPath getIdentifiedPath(QOMObject qomObject) {
        if (qomObject instanceof IdentifiedPath) {
            return (IdentifiedPath) qomObject;
        } else if (qomObject instanceof PrimitiveOperand) {
            PrimitiveOperand primitiveOperand = (PrimitiveOperand) getChildren(0).getObject();
            IdentifiedPath identifiedPath = getLookup().getIdentifiedPath(primitiveOperand.getValue().toString());
            return identifiedPath;
        } else {
            return null;
        }
    }

    public String getObjectPath() {
        return getIdentifiedPath().getObjectPath().toString();
    }

    public String getVariableName() {
        return getIdentifiedPath().getVariableName();
    }

    public ClassExprOperand getClassExprOperand() {
        return getLookup().getClassExprOperand(getVariableName());
    }

    public Operator getOperator() {
        return (Operator) getObject();
    }

}
