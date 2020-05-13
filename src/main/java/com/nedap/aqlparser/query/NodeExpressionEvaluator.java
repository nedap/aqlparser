package com.nedap.aqlparser.query;

import com.nedap.aqlparser.model.NodeExpression;
import com.nedap.aqlparser.model.leaf.Leaf;
import com.nedap.aqlparser.model.leaf.Operator;
import com.nedap.aqlparser.model.leaf.OperatorType;
import com.nedap.archie.rm.RMObject;

public abstract class NodeExpressionEvaluator {

    protected RMObject rmObject;

    protected abstract Boolean evaluateLeaf(Leaf leaf);

    public Boolean evaluate(NodeExpression nodeExpression, RMObject rmObject) {
        this.rmObject = rmObject;
        if (!nodeExpression.hasChildren()) {
//            if (nodeExpression.getObject() instanceof Leaf) {
//                return evaluateLeaf((Leaf) nodeExpression.getObject());
//            } else if (nodeExpression.getObject() instanceof NodeExpression) {
                return evaluate((NodeExpression) nodeExpression.getObject(),rmObject);
//            } else {
//                throw new RuntimeException("Must not be reached");
//            }
        } else if (nodeExpression.isLeaf()) {
            return evaluateLeaf((Leaf) nodeExpression);
        } else {
            OperatorType type = ((Operator) nodeExpression.getObject()).getType();
            switch (type) {
                case AND:
                    return evaluate(nodeExpression.getChildren(0), rmObject) && evaluate(nodeExpression.getChildren(1), rmObject);
                case OR:
                    return evaluate(nodeExpression.getChildren(0), rmObject) || evaluate(nodeExpression.getChildren(1), rmObject);
                case XOR:
                    return evaluate(nodeExpression.getChildren(0), rmObject) ^ evaluate(nodeExpression.getChildren(1), rmObject);
                default:
                    throw new RuntimeException("NYI");
            }
        }
    }

}
