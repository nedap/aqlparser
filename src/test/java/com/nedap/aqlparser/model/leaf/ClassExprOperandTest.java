package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.predicate.ArchetypePredicate;
import com.nedap.aqlparser.model.predicate.StandardPredicate;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassExprOperandTest {

    @Test
    public void className() throws AQLValidationException {
        String aql = "COMPOSITION";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand");
        assertEquals("COMPOSITION",classExprOperand.getClassName());
    }

    @Test
    public void className_variable() throws AQLValidationException {
        String aql = "COMPOSITION c";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand");
        assertEquals("COMPOSITION",classExprOperand.getClassName());
        assertEquals("c",classExprOperand.getVariableName());
    }

    @Test
    public void className_variable_archetypePredicate() throws AQLValidationException {
        String aql = "COMPOSITION c [openEHR-EHR-COMPOSITION.test.v1.0.0]";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand");
        assertEquals("COMPOSITION",classExprOperand.getClassName());
        assertEquals("c",classExprOperand.getVariableName());
        assertTrue(classExprOperand.getPredicate() instanceof ArchetypePredicate);
    }

    @Test
    public void className_variable_standardPredicate() throws AQLValidationException {
        String aql = "EHR e [ehr_id/value=1234]";
        ClassExprOperand classExprOperand = (ClassExprOperand) QOMParser.parse(aql,"classExprOperand");
        assertEquals("EHR",classExprOperand.getClassName());
        assertEquals("e",classExprOperand.getVariableName());
        assertTrue(classExprOperand.getPredicate() instanceof StandardPredicate);
    }
}
