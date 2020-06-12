package com.nedap.aqlparser.model;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.aqlparser.model.leaf.Operator;
import com.nedap.aqlparser.model.leaf.OperatorType;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsExpressionTest {

    @Test
    public void classExprOperand() throws AQLValidationException {
        String aql ="EHR e [ehr_id/value=1234]";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof ClassExprOperand);
    }

    @Test
    public void classExprOperand_contains_classExpr() throws AQLValidationException {
        String aql ="EHR e [ehr_id/value=1234] CONTAINS COMPOSITION c";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.CONTAINS,((Operator) containsExpression.getObject()).getType());
        assertTrue(containsExpression.getChildren(0).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(1).getObject()).getObject() instanceof ClassExprOperand);
    }

    @Test
    public void classExpr_and_classExpr() throws AQLValidationException {
        String aql ="EHR e1 [ehr_id/value=1234] AND e2 [ehr_id/value=12345]";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.AND,((Operator) containsExpression.getObject()).getType());
        assertTrue(containsExpression.getChildren(0).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(0).getObject()).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(1).getObject()).getObject() instanceof ClassExprOperand);
    }

    @Test
    public void classExpr_or_classExpr() throws AQLValidationException {
        String aql ="EHR e1 [ehr_id/value=1234] OR e2 [ehr_id/value=12345]";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) containsExpression.getObject()).getType());
        assertTrue(containsExpression.getChildren(0).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(0).getObject()).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(1).getObject()).getObject() instanceof ClassExprOperand);
    }

    @Test
    public void classExpr_xor_classExpr() throws AQLValidationException {
        String aql ="EHR e1 [ehr_id/value=1234] XOR e2 [ehr_id/value=12345]";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.XOR,((Operator) containsExpression.getObject()).getType());
        assertTrue(containsExpression.getChildren(0).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(0).getObject()).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getObject() instanceof ContainsExpression);
        assertTrue(((ContainsExpression)containsExpression.getChildren(1).getObject()).getObject() instanceof ClassExprOperand);
    }

    @Test
    public void parentheses() throws AQLValidationException {
        String aql ="(EHR e1 [ehr_id/value=1234])";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof ClassExprOperand);
    }

    @Test
    public void conjunction() throws AQLValidationException {
        String aql ="EHR e1 [ehr_id/value=123] OR EHR e2 [ehr_id/value=1234] OR EHR e3 [ehr_id/value=12345]";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) containsExpression.getObject()).getType());
        assertTrue(containsExpression.getChildren(0).getObject() instanceof Operator);
        assertTrue(containsExpression.getChildren(0).getChildren(0).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(0).getChildren(0).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getObject() instanceof ClassExprOperand);
    }

    @Test
    public void conjunction_parentheses() throws AQLValidationException {
        String aql ="EHR e1 [ehr_id/value=123] OR (EHR e2 [ehr_id/value=1234] OR EHR e3 [ehr_id/value=12345])";
        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpr");
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.OR,((Operator) containsExpression.getObject()).getType());
        assertTrue(containsExpression.getChildren(0).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getObject() instanceof Operator);
        assertTrue(containsExpression.getChildren(1).getChildren(0).getObject() instanceof ClassExprOperand);
        assertTrue(containsExpression.getChildren(1).getChildren(1).getObject() instanceof ClassExprOperand);
    }

}
