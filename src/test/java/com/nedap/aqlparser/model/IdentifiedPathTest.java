package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.expression.IdentifiedPath;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdentifiedPathTest {

    @Test
    public void identifiedPath_variable_path() {
        String aql = "o/data[at0001]/data[at0002]/items[at0003]/value/value";
        IdentifiedPath identifiedPath = (IdentifiedPath) QOMParser.parse(aql,"identifiedPath");
        assertEquals("o",identifiedPath.getVariableName());
        assertEquals("data[at0001]/data[at0002]/items[at0003]/value/value",identifiedPath.getPath());
    }

    @Test
    public void identifiedPath_variable_predicate() {
        String aql = "o[name/value=name]";
        IdentifiedPath identifiedPath = (IdentifiedPath) QOMParser.parse(aql,"identifiedPath");
        assertEquals("o",identifiedPath.getVariableName());
        assertEquals("[name/value = name]",identifiedPath.getPredicate().toString());
    }

    @Test
    public void identifiedPath_variable_predicate_path() {
        String aql = "o[name/value=name]/data[at0001]/data[at0002]/items[at0003]/value/value";
        IdentifiedPath identifiedPath = (IdentifiedPath) QOMParser.parse(aql,"identifiedPath");
        assertEquals("o",identifiedPath.getVariableName());
        assertEquals("[name/value = name]",identifiedPath.getPredicate().toString());
        assertEquals("data[at0001]/data[at0002]/items[at0003]/value/value",identifiedPath.getPath());
    }
}
