package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IdentifiedExprOperandTest extends BaseTest {

    @Test
    public void primitiveOperand() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude >= 42";
        IdentifiedExprOperand identifiedExprOperand = (IdentifiedExprOperand) QOMParser.parse(aql,"identifiedExprOperand", lookup);
        assertEquals("c",identifiedExprOperand.getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",identifiedExprOperand.getObjectPath());
        assertEquals(OperatorType.GREATER_EQUAL_TO,identifiedExprOperand.getOperator().getType());
        assertEquals(42,((PrimitiveOperand)identifiedExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void matchesOperand() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude MATCHES {42, 1909}";
        IdentifiedExprOperand identifiedExprOperand = (IdentifiedExprOperand) QOMParser.parse(aql,"identifiedExprOperand", lookup);
        assertEquals("c",identifiedExprOperand.getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",identifiedExprOperand.getObjectPath());
        assertEquals(OperatorType.MATCHES,identifiedExprOperand.getOperator().getType());
        ValueList valueList = (ValueList) identifiedExprOperand.getChildren(1).getObject();
        assertEquals(42,valueList.item(0).getValue());
        assertEquals(1909,valueList.item(1).getValue());
    }
}
