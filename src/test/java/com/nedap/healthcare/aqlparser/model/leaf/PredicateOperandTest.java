package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PredicateOperandTest extends BaseTest {

    @Test
    public void identifiedPath() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        IdentifiedPath identifiedPath = (IdentifiedPath) QOMParser.parse(aql,"predicateOperand", lookup);
        assertEquals("c",identifiedPath.getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",identifiedPath.getObjectPath().toString());
    }

    @Test
    public void pritmitiveOperand() throws AQLValidationException {
        String aql = "42";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"predicateOperand", lookup);
        assertEquals(42,primitiveOperand.getValue());
    }

}
