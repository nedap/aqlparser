package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.NodeId;
import com.nedap.healthcare.aqlparser.model.leaf.NodePredicateExprOperand;
import com.nedap.healthcare.aqlparser.model.leaf.Operator;
import com.nedap.healthcare.aqlparser.model.leaf.OperatorType;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;


public class NodePredicateExprTest extends BaseTest {

    @Test
    public void nodePredicateExprOperand() throws AQLValidationException {
        String aql = "id42";
        NodePredicateExpression nodePredicateExpression = (NodePredicateExpression) QOMParser.parse(aql,"nodePredicateExpr", lookup);
        assertTrue(nodePredicateExpression.getObject() instanceof NodePredicateExprOperand);
        assertEquals("id42", ((NodeId) ((NodePredicateExprOperand) nodePredicateExpression.getObject()).getObject()).getNodeId());
    }

    @Test
    public void nodePredicateExpr_and_nodePredicateExpr() throws AQLValidationException {
        String aql = "id42 AND id43";
        NodePredicateExpression nodePredicateExpression = (NodePredicateExpression) QOMParser.parse(aql,"nodePredicateExpr", lookup);
        assertTrue(nodePredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) nodePredicateExpression.getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(0) instanceof NodePredicateExpression);
        assertTrue(nodePredicateExpression.getChildren(1) instanceof NodePredicateExpression);
    }

    @Test
    public void nodePredicateExpr_or_nodePredicateExpr() throws AQLValidationException {
        String aql = "id42 OR id43";
        NodePredicateExpression nodePredicateExpression = (NodePredicateExpression) QOMParser.parse(aql,"nodePredicateExpr", lookup);
        assertTrue(nodePredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) nodePredicateExpression.getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(0) instanceof NodePredicateExpression);
        assertTrue(nodePredicateExpression.getChildren(1) instanceof NodePredicateExpression);
    }

    @Test
    public void nodePredicateExpr_xor_nodePredicateExpr() throws AQLValidationException {
        String aql = "id42 XOR id43";
        NodePredicateExpression nodePredicateExpression = (NodePredicateExpression) QOMParser.parse(aql,"nodePredicateExpr", lookup);
        assertTrue(nodePredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.XOR,((Operator) nodePredicateExpression.getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(0) instanceof NodePredicateExpression);
        assertTrue(nodePredicateExpression.getChildren(1) instanceof NodePredicateExpression);
    }

    @Test
    public void conjunction() throws AQLValidationException {
        String aql = "id42 OR id43 OR id44";
        NodePredicateExpression nodePredicateExpression = (NodePredicateExpression) QOMParser.parse(aql,"nodePredicateExpr", lookup);
        assertTrue(nodePredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) nodePredicateExpression.getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(0).getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) nodePredicateExpression.getChildren(0).getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(0).getChildren(0).getObject() instanceof NodePredicateExprOperand);
        assertTrue(nodePredicateExpression.getChildren(0).getChildren(1).getObject() instanceof NodePredicateExprOperand);
        assertTrue(nodePredicateExpression.getChildren(1).getObject() instanceof NodePredicateExprOperand);
    }

    @Test
    public void conjunction_parentheses() throws AQLValidationException {
        String aql = "id42 OR (id43 OR id44)";
        NodePredicateExpression nodePredicateExpression = (NodePredicateExpression) QOMParser.parse(aql,"nodePredicateExpr", lookup);
        assertTrue(nodePredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) nodePredicateExpression.getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(1).getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) nodePredicateExpression.getChildren(1).getObject()).getType());
        assertTrue(nodePredicateExpression.getChildren(1).getChildren(0).getObject() instanceof NodePredicateExprOperand);
        assertTrue(nodePredicateExpression.getChildren(1).getChildren(1).getObject() instanceof NodePredicateExprOperand);
        assertTrue(nodePredicateExpression.getChildren(0).getObject() instanceof NodePredicateExprOperand);
    }
}
