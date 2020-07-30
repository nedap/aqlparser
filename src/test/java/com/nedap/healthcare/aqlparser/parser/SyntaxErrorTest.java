package com.nedap.healthcare.aqlparser.parser;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLParsingException;
import com.nedap.healthcare.aqlparser.exception.AQLUnsupportedFeatureException;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SyntaxErrorTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

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

        thrown.expect(AQLParsingException.class);
        thrown.expectMessage("Could not parse QOM: \n" +
                "Error: syntax error at 4:4: [@68,148:152='FROMS',<30>,4:4]. msg: missing FROM at 'FROMS'");
        QOMParser.parse(aql, lookup);
    }
}
