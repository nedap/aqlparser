package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.Lookup;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PrimitiveOperandTest {

    @Test
    public void string_test() throws AQLValidationException {
        String aql = "'someString'";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals("someString",primitiveOperand.getValue());

        aql = "\"someString\"";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals("someString",primitiveOperand.getValue());
    }

    @Test
    public void integer_test() throws AQLValidationException {
        String aql = "42";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(42,primitiveOperand.getValue());
    }

    @Test
    public void float_test() throws AQLValidationException {
        String aql = "42.0";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(42F,primitiveOperand.getValue());
    }

    @Test
    public void date_test() throws AQLValidationException {
        String aql = "1909-12-19";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(LocalDateTime.of(1909,12,19,0,0),primitiveOperand.getValue());

        aql = "1909-12-19 19:09";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(LocalDateTime.of(1909,12,19,19,9),primitiveOperand.getValue());

        aql = "1909-12-19 19:09:09";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(LocalDateTime.of(1909,12,19,19,9,9),primitiveOperand.getValue());
    }

    @Test
    public void boolean_test() throws AQLValidationException {
        String aql = "true";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(true,primitiveOperand.getValue());

        aql = "TRUE";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(true,primitiveOperand.getValue());

        aql = "false";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(false,primitiveOperand.getValue());

        aql = "FALSE";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(false,primitiveOperand.getValue());
    }

    @Test
    public void parameter_test() throws AQLValidationException {
        Lookup.addParameter("$someString","'someString'");
        Lookup.addParameter("$someInt",42);
        Lookup.addParameter("$someFloat",42F);
        Lookup.addParameter("$someDate","1909-12-19 19:09");

        String aql = "$someString";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals("someString",primitiveOperand.getValue());

        aql = "$someInt";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(42,primitiveOperand.getValue());

        aql = "$someFloat";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(42F,primitiveOperand.getValue());

        aql = "$someDate";
        primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"primitiveOperand");
        assertEquals(LocalDateTime.of(1909,12,19,19,9),primitiveOperand.getValue());
    }

}
