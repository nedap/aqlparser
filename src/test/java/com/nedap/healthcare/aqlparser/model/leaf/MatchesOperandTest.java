package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchesOperandTest extends BaseTest {

    @Test
    public void valueList() throws AQLValidationException {
        String aql ="1, 42, 'someString', true";
        ValueList valueList = (ValueList) QOMParser.parse(aql,"matchesOperand", lookup);
        assertEquals(1,valueList.item(0).getValue());
        assertEquals(42,valueList.item(1).getValue());
        assertEquals("someString",valueList.item(2).getValue());
        assertEquals(true,valueList.item(3).getValue());
    }

    @Test
    public void urivalue() throws AQLValidationException {
        String aql ="terminology://snomed-ct/hierarchy?rootConceptId=50043002";
        TerminalNodeLeaf uriValue = (TerminalNodeLeaf) QOMParser.parse(aql,"matchesOperand", lookup);
        assertEquals("terminology://snomed-ct/hierarchy?rootConceptId=50043002",uriValue.getValue());
    }

}
