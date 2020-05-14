package com.nedap.aqlparser.query;

import com.nedap.aqlparser.model.NodeExpression;
import com.nedap.aqlparser.model.leaf.Operator;
import com.nedap.aqlparser.model.leaf.OperatorType;
import com.nedap.archie.rm.RMObject;

public class NodeExpressionEvaluator {

    public static Boolean evaluate(NodeExpression nodeExpression, RMObject rmObject) {
        if (!nodeExpression.hasChildren()) {
            return evaluate((NodeExpression) nodeExpression.getObject(),rmObject);
        } else if (nodeExpression.isLeaf()) {
            return nodeExpression.evaluate(rmObject);
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
