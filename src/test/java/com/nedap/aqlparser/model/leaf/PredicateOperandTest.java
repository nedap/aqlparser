package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PredicateOperandTest {

    @Test
    public void identifiedPath() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        IdentifiedPath identifiedPath = (IdentifiedPath) QOMParser.parse(aql,"predicateOperand");
        assertEquals("c",identifiedPath.getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",identifiedPath.getObjectPath().toString());
    }

    @Test
    public void pritmitiveOperand() throws AQLValidationException {
        String aql = "42";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"predicateOperand");
        assertEquals(42,primitiveOperand.getValue());
    }

}
