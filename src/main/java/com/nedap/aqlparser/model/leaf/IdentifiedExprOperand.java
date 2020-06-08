package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.Lookup;
import com.nedap.aqlparser.model.NodeExpression;

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
public class IdentifiedExprOperand extends NodeExpression implements Leaf {

    public IdentifiedExprOperand(AQLParser.IdentifiedExprOperandContext ctx){
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedExprOperandContext ctx) {
        setObject(ctx.COMPARABLEOPERATOR(),ctx.MATCHES());
        addChildren(ctx.predicateOperand(0),ctx.predicateOperand(1),ctx.matchesOperand());
    }

    @Override
    public void validate() throws AQLValidationException {
        if (getChildren(0).getObject() instanceof PrimitiveOperand) {
            PrimitiveOperand primitiveOperand = (PrimitiveOperand) getChildren(0).getObject();
            IdentifiedPath identifiedPath = Lookup.getIdentifiedPath(primitiveOperand.getValue().toString());
            if (identifiedPath == null) {
                throw new AQLValidationException("Failed to find path for alias " +
                        ((PrimitiveOperand) getChildren(0).getObject()).getValue().toString());
            }
        } else if (!(getChildren(0).getObject() instanceof IdentifiedPath)) {
            throw new AQLValidationException("IdentifiedPath required in IdentifiedExprOperand");
        }
    }

    public IdentifiedPath getIdentifiedPath() {
        if (getChildren(0).getObject() instanceof IdentifiedPath) {
            return (IdentifiedPath) getChildren(0).getObject();
        } else if (getChildren(0).getObject() instanceof PrimitiveOperand) {
            PrimitiveOperand primitiveOperand = (PrimitiveOperand) getChildren(0).getObject();
            return Lookup.getIdentifiedPath(primitiveOperand.getValue().toString());
        } else {
            throw new RuntimeException("Must not be reached");
        }
    }

    public String getObjectPath() {
        return getIdentifiedPath().getObjectPath().toString();
    }

    public String getVariableName() {
        return getIdentifiedPath().getVariableName();
    }

    public ClassExprOperand getClassExprOperand() {
        return Lookup.getClassExprOperand(getVariableName());
    }


}
