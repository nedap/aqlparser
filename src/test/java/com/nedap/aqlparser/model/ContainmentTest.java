package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.expression.ClassExpression;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainmentTest {

    @Test
    public void containment_classExpr() {
        String aql = "OBSERVATION o[openEHR-EHR-OBSERVATION.test.v1]";
        Containment containment = (Containment) QOMParser.parse(aql,"contains");
        assertEquals("OBSERVATION",containment.getFromClass().getClassName());
        assertEquals("o",containment.getFromClass().getVariableName());
        assertEquals("openEHR-EHR-OBSERVATION.test.v1",containment.getFromClass().getPredicate().getRightOperand().toString());
    }

    @Test
    public void containment_classExpr_containsExpr() {
        String aql = "COMPOSITION c[openEHR-EHR-COMPOSITION.test.v1] CONTAINS OBSERVATION o [openEHR-EHR-OBSERVATION.test.v1]";
        Containment containment = (Containment) QOMParser.parse(aql,"contains");
        assertEquals("COMPOSITION",containment.getFromClass().getClassName());
        assertEquals("c",containment.getFromClass().getVariableName());
        assertEquals("openEHR-EHR-COMPOSITION.test.v1",containment.getFromClass().getPredicate().getRightOperand().toString());
        assertEquals("openEHR-EHR-OBSERVATION.test.v1",((ClassExpression) containment.getContains().getExpression()).getPredicate().toString());
        assertEquals("OBSERVATION",((ClassExpression) containment.getContains().getExpression()).getClassName());
        assertEquals("o",((ClassExpression) containment.getContains().getExpression()).getVariableName());
    }
}
