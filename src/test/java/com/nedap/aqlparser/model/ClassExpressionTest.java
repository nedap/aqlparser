package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.expression.ClassExpression;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassExpressionTest {

    @Test
    public void classExpression_className() {
        String aql = "OBSERVATION";
        ClassExpression classExpression = (ClassExpression) QOMParser.parse(aql,"classExpr");
        assertEquals("OBSERVATION",classExpression.getClassName());
    }

    @Test
    public void classExpression_className_variableName() {
        String aql = "OBSERVATION o";
        ClassExpression classExpression = (ClassExpression) QOMParser.parse(aql,"classExpr");
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o",classExpression.getVariableName());
    }

    @Test
    public void classExpression_className_variableName_archetypePredicate() {
        String aql = "OBSERVATION o[openEHR-EHR-OBSERVATION.referral.v1]";
        ClassExpression classExpression = (ClassExpression) QOMParser.parse(aql,"classExpr");
        assertEquals("OBSERVATION",classExpression.getClassName());
        assertEquals("o",classExpression.getVariableName());
        assertEquals("openEHR-EHR-OBSERVATION.referral.v1",classExpression.getPredicate().getRightOperand().toString());
    }
}
