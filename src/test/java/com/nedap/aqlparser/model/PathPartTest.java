package com.nedap.aqlparser.model;

import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathPartTest {

    @Test
    public void pathPartTest() {
        String aql = "data[id42]";
        PathPart pathPart = (PathPart) QOMParser.parse(aql,"pathPart");
        assertEquals("data",pathPart.getIdentifier());
        assertEquals("[id42]",pathPart.getNodePredicate().toString());
    }
}
