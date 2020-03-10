package com.nedap.aqlparser.model;

import com.nedap.aqlparser.BaseTest;
import com.nedap.aqlparser.model.expression.*;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;


public class ContainsExpressionTest extends BaseTest {

    @Test
    public void containsExpression() {
        String aql = "COMPOSITION c [openEHR-EHR-COMPOSITION.test.v1]";

        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpression");
        assertEquals("openEHR-EHR-COMPOSITION.test.v1",((ClassExpression) containsExpression.getExpression()).getPredicate().toString());
        assertEquals("COMPOSITION",((ClassExpression) containsExpression.getExpression()).getClassName());
        assertEquals("c",((ClassExpression) containsExpression.getExpression()).getVariableName());
    }

    @Test
    public void containsExpression_and() {
        String aql = "OBSERVATION o1 [openEHR-EHR-OBSERVATION.test1.v1] AND OBSERVATION o2 [openEHR-EHR-OBSERVATION.test2.v1]";

        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpression");
        assertEquals(OperatorType.AND,((Operator) containsExpression.getExpression()).getType());

        ClassExpression classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getLeftOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test1.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o1",classExpression.getVariableName());

        classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getRightOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test2.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o2",classExpression.getVariableName());
    }

    @Test
    public void containsExpression_or() {
        String aql = "OBSERVATION o1 [openEHR-EHR-OBSERVATION.test1.v1] OR OBSERVATION o2 [openEHR-EHR-OBSERVATION.test2.v1]";

        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpression");
        assertEquals(OperatorType.OR,((Operator) containsExpression.getExpression()).getType());

        ClassExpression classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getLeftOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test1.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o1",classExpression.getVariableName());

        classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getRightOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test2.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o2",classExpression.getVariableName());
    }

    @Test
    public void containsExpression_or_parentheses() {
        String aql = "(OBSERVATION o1 [openEHR-EHR-OBSERVATION.test1.v1] OR OBSERVATION o2 [openEHR-EHR-OBSERVATION.test2.v1])";

        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpression");
        assertEquals(OperatorType.OR,((Operator) containsExpression.getExpression()).getType());

        ClassExpression classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getLeftOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test1.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o1",classExpression.getVariableName());

        classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getRightOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test2.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o2",classExpression.getVariableName());
    }

    @Test
    public void containsExpression_multipleAnd() {
        String aql = "OBSERVATION o1 [openEHR-EHR-OBSERVATION.test1.v1] AND OBSERVATION o2 [openEHR-EHR-OBSERVATION.test2.v1] AND OBSERVATION o3 [openEHR-EHR-OBSERVATION.test3.v1]";

        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpression");

        ContainsExpression leftOperand = (ContainsExpression) ((Operator) containsExpression.getExpression()).getLeftOperand();
        ClassExpression classExpression = (ClassExpression) ((Operator) leftOperand.getExpression()).getLeftOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test1.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o1",classExpression.getVariableName());

        classExpression = (ClassExpression) ((Operator) leftOperand.getExpression()).getRightOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test2.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o2",classExpression.getVariableName());

        classExpression = (ClassExpression) ((Operator) containsExpression.getExpression()).getRightOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test3.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o3",classExpression.getVariableName());
    }


    @Test
    public void containsExpression_parentheses() {
        String aql = "OBSERVATION o1 [openEHR-EHR-OBSERVATION.test1.v1] AND (OBSERVATION o2 [openEHR-EHR-OBSERVATION.test2.v1] OR OBSERVATION o3 [openEHR-EHR-OBSERVATION.test3.v1])";

        ContainsExpression containsExpression = (ContainsExpression) QOMParser.parse(aql,"containsExpression");


        ContainsExpression leftOperand = (ContainsExpression) ((Operator) containsExpression.getExpression()).getLeftOperand();
        ClassExpression classExpression = (ClassExpression) leftOperand.getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test1.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o1",classExpression.getVariableName());

        ContainsExpression rightOperand =  (ContainsExpression) ((Operator) containsExpression.getExpression()).getRightOperand();
        classExpression = (ClassExpression) ((Operator) rightOperand.getExpression()).getLeftOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test2.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o2",classExpression.getVariableName());

        classExpression = (ClassExpression) ((Operator) rightOperand.getExpression()).getRightOperand().getExpression();
        assertEquals("openEHR-EHR-OBSERVATION.test3.v1",classExpression.getPredicate().toString());
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o3",classExpression.getVariableName());

    }

}
