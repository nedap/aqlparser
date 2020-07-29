package com.nedap.healthcare.aqlparser.parser;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QOMParserTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void invalidStartRuleName() throws AQLValidationException {
        String aql = "someAQL";

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Could not invoke ParseTree.someStartRuleName");
        QOMParser.parse(aql,"someStartRuleName", lookup);
    }
}
