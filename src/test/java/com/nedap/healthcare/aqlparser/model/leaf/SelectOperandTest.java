package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SelectOperandTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void identifiedPath() throws AQLValidationException {
        //Add variable c -- will throw AQLValidationException otherwise
        QOMParser.parse("COMPOSITION c","classExprOperand", lookup);
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        SelectOperand selectOperand = (SelectOperand) QOMParser.parse(aql,"selectOperand", lookup);
        assertEquals("c",selectOperand.getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectOperand.getIdentifiedPath().getObjectPath().toString());
    }

    @Test
    public void identifiedPath_alias() throws AQLValidationException {
        //Add variable c -- will throw AQLValidationException otherwise
        QOMParser.parse("COMPOSITION c","classExprOperand", lookup);
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude AS bw";
        SelectOperand selectOperand = (SelectOperand) QOMParser.parse(aql,"selectOperand", lookup);
        assertEquals("c",selectOperand.getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectOperand.getIdentifiedPath().getObjectPath().toString());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude", lookup.getIdentifiedPath("bw").getObjectPath().toString());
    }

    @Test
    public void identifiedPath_invalidVariable() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        thrown.expect(AQLValidationException.class);
        thrown.expectMessage("IdentifiedPath: Invalid variable: c");
        QOMParser.parse(aql,"selectOperand", lookup);
    }
}
