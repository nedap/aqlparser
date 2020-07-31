package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdentifiedPathTest extends BaseTest {

    @Test
    public void identifiedPath() throws AQLValidationException {
        //Add variable c -- will throw AQLValidationException otherwise
        QOMParser.parse("COMPOSITION c","classExprOperand", lookup);
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        IdentifiedPath identifiedPath = (IdentifiedPath) QOMParser.parse(aql,"identifiedPath", lookup);
        assertEquals("c",identifiedPath.getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",identifiedPath.getObjectPath().toString());
    }
}
