package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.Operator;
import com.nedap.healthcare.aqlparser.model.leaf.OperatorType;
import com.nedap.healthcare.aqlparser.model.leaf.StandardPredicateExprOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StandardPredicateExprTest extends BaseTest {

    @Test
    public void standardPredicateExprOperand() throws AQLValidationException {
        String aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 40";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof StandardPredicateExprOperand);
    }

    @Test
    public void not() throws AQLValidationException {
        String aql = "NOT ehr_id/value = 42";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.NOT,((Operator) standardPredicateExpression.getObject()).getType());
        assertEquals(1,standardPredicateExpression.getChildren().size());
        assertTrue(standardPredicateExpression.getChildren(0).getObject() instanceof StandardPredicateExprOperand);
    }

    @Test
    public void and() throws AQLValidationException {
        String aql = "ehr_id/value = 42 AND ehr_id/value = 43";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) standardPredicateExpression.getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(0).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(1).getObject() instanceof StandardPredicateExprOperand);
    }

    @Test
    public void xor() throws AQLValidationException {
        String aql = "ehr_id/value = 42 XOR ehr_id/value = 43";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.XOR,((Operator) standardPredicateExpression.getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(0).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(1).getObject() instanceof StandardPredicateExprOperand);
    }

    @Test
    public void or() throws AQLValidationException {
        String aql = "ehr_id/value = 42 OR ehr_id/value = 43";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) standardPredicateExpression.getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(0).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(1).getObject() instanceof StandardPredicateExprOperand);
    }

    @Test
    public void conjunction() throws AQLValidationException {
        String aql = "ehr_id/value = 42 AND ehr_id/value = 43 AND ehr_id/value = 44";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) standardPredicateExpression.getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(0).getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) standardPredicateExpression.getChildren(0).getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(0).getChildren(0).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(0).getChildren(1).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(1).getObject() instanceof StandardPredicateExprOperand);
    }

    @Test
    public void conjunction_parentheses() throws AQLValidationException {
        String aql = "ehr_id/value = 42 AND (ehr_id/value = 43 AND ehr_id/value = 44)";
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) QOMParser.parse(aql,"standardPredicateExpr", lookup);
        assertTrue(standardPredicateExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) standardPredicateExpression.getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(1).getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) standardPredicateExpression.getChildren(1).getObject()).getType());
        assertTrue(standardPredicateExpression.getChildren(1).getChildren(0).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(1).getChildren(1).getObject() instanceof StandardPredicateExprOperand);
        assertTrue(standardPredicateExpression.getChildren(0).getObject() instanceof StandardPredicateExprOperand);
    }

}
