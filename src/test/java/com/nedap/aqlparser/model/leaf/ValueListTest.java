package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValueListTest {

    @Test
    public void primitiveOperand() throws AQLValidationException {
        String aql ="1";
        ValueList valueList = (ValueList) QOMParser.parse(aql,"valueList");
        assertEquals(1,valueList.item(0).getValue());
    }

    @Test
    public void multiple_primitiveOperand() throws AQLValidationException {
        String aql ="1, 42, 'someString', true";
        ValueList valueList = (ValueList) QOMParser.parse(aql,"valueList");
        assertEquals(1,valueList.item(0).getValue());
        assertEquals(42,valueList.item(1).getValue());
        assertEquals("someString",valueList.item(2).getValue());
        assertEquals(true,valueList.item(3).getValue());
    }

}
