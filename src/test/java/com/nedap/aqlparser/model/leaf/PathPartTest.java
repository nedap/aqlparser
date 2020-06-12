package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;


public class PathPartTest {

    @Test
    public void identifier() throws AQLValidationException {
        String aql = "data";
        PathPart pathPart = (PathPart) QOMParser.parse(aql,"pathPart");
        assertEquals("data",pathPart.toString());
    }

    @Test
    public void identifier_nodePredicate() throws AQLValidationException {
        String aql = "data[id42]";
        PathPart pathPart = (PathPart) QOMParser.parse(aql,"pathPart");
        assertEquals("data[id42]",pathPart.toString());
    }

}
