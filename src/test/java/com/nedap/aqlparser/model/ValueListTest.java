package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.expression.ValueList;
import com.nedap.aqlparser.model.expression.operand.Operand;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ValueListTest {

    @Test
    public void valueList_String() {
        String aql = "'Operand1', 'Operand2', 'Operand3', 'Operand4'";
        ValueList valueList = (ValueList) QOMParser.parse(aql,"valueListItems");
        List<Operand> operands = valueList.getValues();
        assertEquals(4,operands.size());
        assertEquals("'Operand1'",operands.get(0).getValue());
        assertEquals("'Operand2'",operands.get(1).getValue());
        assertEquals("'Operand3'",operands.get(2).getValue());
        assertEquals("'Operand4'",operands.get(3).getValue());
    }
}
