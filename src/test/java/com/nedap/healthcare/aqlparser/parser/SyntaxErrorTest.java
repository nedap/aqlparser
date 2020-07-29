package com.nedap.healthcare.aqlparser.parser;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SyntaxErrorTest {

    @Test
    public void syntaxErrorTest() {
        String aql = "SELECT\n" +
                "   o/data[id2]/events[id7]/data[id4]/items[id5]/value[id1060]/magnitude,\n" +
                "   o/data[id2]/events[id7]/data[id4]/items[id6]/value/magnitude\n" +
                "    FROMS \n" + //this is a syntax error
                "    EHR [ehr_id/value='1234']\n" +
                "        CONTAINS OBSERVATION o [openEHR-EHR-OBSERVATION.blood_pressure.v1]\n" +
                "WHERE\n" +
                        "   o/data[id2]/events[id7]/data[id4]/items[id5]/value[id1060]/magnitude >= 140";
        try {
            QOMParser.parse(aql, new Lookup());
            fail("expected an exception");
        } catch(AQLValidationException e) {
            assertEquals("line number must be correct", 4, e.getLineNumber().intValue());
            assertEquals("character position must be correct", 4, e.getCharPosition().intValue());
            assertEquals("token length must be correct", 5, e.getLength().intValue());
        }
    }
}
