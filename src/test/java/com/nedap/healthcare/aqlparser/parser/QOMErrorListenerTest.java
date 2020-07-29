package com.nedap.healthcare.aqlparser.parser;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QOMErrorListenerTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();


    @Test
    public void invalidAQL() throws AQLValidationException {
        String aql = "FROM ...";

        thrown.expect(AQLValidationException.class);
        thrown.expectMessage("Line 1:0 mismatched input 'FROM' expecting SELECT");
        QOMParser.parse(aql,lookup);
    }
}
