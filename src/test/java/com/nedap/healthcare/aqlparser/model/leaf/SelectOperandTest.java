package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectOperandTest {

    @Test
    public void identifiedPath() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        SelectOperand selectOperand = (SelectOperand) QOMParser.parse(aql,"selectOperand");
        assertEquals("c",selectOperand.getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectOperand.getIdentifiedPath().getObjectPath().toString());
    }

    @Test
    public void identifiedPath_alias() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude AS bw";
        SelectOperand selectOperand = (SelectOperand) QOMParser.parse(aql,"selectOperand");
        assertEquals("c",selectOperand.getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectOperand.getIdentifiedPath().getObjectPath().toString());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude", Lookup.getIdentifiedPath("bw").getObjectPath().toString());

    }
}
