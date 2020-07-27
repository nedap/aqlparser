package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PrimitiveOperandTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void string_test() throws AQLValidationException {
        String aql = "'someString'";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals("someString",primitiveOperand.getValue());

        aql = "\"someString\"";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals("someString",primitiveOperand.getValue());
    }

    @Test
    public void integer_test() throws AQLValidationException {
        String aql = "42";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(42,primitiveOperand.getValue());
    }

    @Test
    public void float_test() throws AQLValidationException {
        String aql = "42.0";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(42F,primitiveOperand.getValue());
    }

    @Test
    public void date_test() throws AQLValidationException {
        String aql = "1909-12-19";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(LocalDateTime.of(1909,12,19,0,0),primitiveOperand.getValue());

        aql = "1909-12-19 19:09";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(LocalDateTime.of(1909,12,19,19,9),primitiveOperand.getValue());

        aql = "1909-12-19 19:09:09";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(LocalDateTime.of(1909,12,19,19,9,9),primitiveOperand.getValue());
    }

    @Test
    public void boolean_test() throws AQLValidationException {
        String aql = "true";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(true,primitiveOperand.getValue());

        aql = "TRUE";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(true,primitiveOperand.getValue());

        aql = "false";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(false,primitiveOperand.getValue());

        aql = "FALSE";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(false,primitiveOperand.getValue());
    }

    @Test
    public void parameter_test() throws AQLValidationException {
        lookup.addParameter("$someString","'someString'");
        lookup.addParameter("$someInt",42);
        lookup.addParameter("$someFloat",42F);
        lookup.addParameter("$someDate","1909-12-19 19:09");

        String aql = "$someString";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals("someString",primitiveOperand.getValue());

        aql = "$someInt";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(42,primitiveOperand.getValue());

        aql = "$someFloat";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(42F,primitiveOperand.getValue());

        aql = "$someDate";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand", lookup);
        assertEquals(LocalDateTime.of(1909,12,19,19,9),primitiveOperand.getValue());
    }

    @Test
    public void unknownParameter() throws AQLValidationException {
        String aql = "$someParameter";

        thrown.expect(AQLValidationException.class);
        thrown.expectMessage("Could not resolve parameter $someParameter");
        QOMParser.parse(aql,"primitiveOperand", lookup);
    }

}
