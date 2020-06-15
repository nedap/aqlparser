package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectPathTest {

    @Test
    public void pathPart() throws AQLValidationException {
        String aql = "data[id42]";
        ObjectPath objectPath = (ObjectPath) QOMParser.parse(aql,"objectPath");
        assertEquals("/data[id42]",objectPath.toString());
    }

    @Test
    public void objectPath() throws AQLValidationException {
        String aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        ObjectPath objectPath = (ObjectPath) QOMParser.parse(aql,"objectPath");
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",objectPath.toString());
    }
}
