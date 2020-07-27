package com.nedap.healthcare.aqlparser.util;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLUnsupportedFeatureException;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QOMParserUtilTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void unsupported() throws AQLValidationException {
        //Well, this is a bit hacky...
        TerminalNode terminalNode = new TerminalNodeImpl(new CommonToken(AQLParser.OPEN));

        thrown.expect(AQLUnsupportedFeatureException.class);
        QOMParserUtil.parse(lookup, terminalNode);
    }

}
