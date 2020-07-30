package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassExprOperandTest extends BaseTest {

    @Test
    public void className() throws AQLValidationException {
        String aql = "COMPOSITION";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand", lookup);
        assertEquals("COMPOSITION",classExprOperand.getClassName());
    }

    @Test
    public void className_variable() throws AQLValidationException {
        String aql = "COMPOSITION c";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand", lookup);
        assertEquals("COMPOSITION",classExprOperand.getClassName());
        assertEquals("c",classExprOperand.getVariableName());
    }

    @Test
    public void className_variable_archetypePredicate() throws AQLValidationException {
        String aql = "COMPOSITION c [openEHR-EHR-COMPOSITION.test.v1.0.0]";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand", lookup);
        assertEquals("COMPOSITION",classExprOperand.getClassName());
        assertEquals("c",classExprOperand.getVariableName());
        assertEquals("[openEHR-EHR-COMPOSITION.test.v1.0.0]",classExprOperand.getPredicate().toString());
    }

    @Test
    public void className_variable_standardPredicate() throws AQLValidationException {
        String aql = "EHR e [ehr_id/value=1234]";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand", lookup);
        assertEquals("EHR",classExprOperand.getClassName());
        assertEquals("e",classExprOperand.getVariableName());
        assertEquals("[/ehr_id/value = 1234]",classExprOperand.getPredicate().toString());
    }
}
