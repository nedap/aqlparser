package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.IdentifiedExprOperand;
import com.nedap.healthcare.aqlparser.model.leaf.Operator;
import com.nedap.healthcare.aqlparser.model.leaf.OperatorType;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IdentifiedExprTest extends BaseTest {

    @Test
    public void identifiedExprOperand() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude >= 42";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertTrue(identifiedExpression.getObject() instanceof IdentifiedExprOperand);
    }

    @Test
    public void not() throws AQLValidationException {
        String aql = "NOT c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 42";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertEquals(OperatorType.NOT,((Operator) identifiedExpression.getObject()).getType());
        assertEquals(1,identifiedExpression.getChildren().size());
        assertTrue(identifiedExpression.getChildren(0).getObject() instanceof IdentifiedExprOperand);
    }

    @Test
    public void exists() throws AQLValidationException {
        String aql = "EXISTS c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertEquals(OperatorType.EXISTS,((Operator) identifiedExpression.getObject()).getType());
        assertEquals(1,identifiedExpression.getChildren().size());
        assertTrue(identifiedExpression.getChildren(0).getObject() instanceof IdentifiedExprOperand);
    }

    @Test
    public void and() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 42 " +
                "AND c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 1909-12-19";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertEquals(OperatorType.AND,((Operator) identifiedExpression.getObject()).getType());
        assertTrue(identifiedExpression.getChildren(0).getObject() instanceof IdentifiedExprOperand);
        assertTrue(identifiedExpression.getChildren(1).getObject() instanceof IdentifiedExprOperand);
    }

    @Test
    public void or() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 42 " +
                "OR c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 1909-12-19";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertEquals(OperatorType.OR,((Operator) identifiedExpression.getObject()).getType());
        assertTrue(identifiedExpression.getChildren(0).getObject() instanceof IdentifiedExprOperand);
        assertTrue(identifiedExpression.getChildren(1).getObject() instanceof IdentifiedExprOperand);
    }

    @Test
    public void containment() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 42 " +
                "OR c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 43 " +
                "OR c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 44";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertEquals(OperatorType.OR,((Operator) identifiedExpression.getObject()).getType());
        assertTrue(identifiedExpression.getChildren(0).getChildren(0).getObject() instanceof IdentifiedExprOperand);
        assertTrue(identifiedExpression.getChildren(0).getChildren(1).getObject() instanceof IdentifiedExprOperand);
        assertTrue(identifiedExpression.getChildren(1).getObject() instanceof IdentifiedExprOperand);
    }

    @Test
    public void containment_parentheses() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 42 " +
                "OR (c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 43 " +
                "OR c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 44)";
        NodeExpression identifiedExpression = (NodeExpression) QOMParser.parse(aql,"identifiedExpr", lookup);
        assertEquals(OperatorType.OR,((Operator) identifiedExpression.getObject()).getType());
        assertTrue(identifiedExpression.getChildren(1).getChildren(0).getObject() instanceof IdentifiedExprOperand);
        assertTrue(identifiedExpression.getChildren(1).getChildren(1).getObject() instanceof IdentifiedExprOperand);
        assertTrue(identifiedExpression.getChildren(0).getObject() instanceof IdentifiedExprOperand);
    }
}
