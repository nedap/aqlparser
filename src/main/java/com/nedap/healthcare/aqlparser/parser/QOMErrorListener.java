package com.nedap.healthcare.aqlparser.parser;

import com.nedap.archie.antlr.errors.ANTLRParserErrors;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

public class QOMErrorListener extends BaseErrorListener {

    private final ANTLRParserErrors errors;

    public QOMErrorListener(ANTLRParserErrors errors) {
        this.errors = errors;
    }

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg, RecognitionException e) throws AQLValidationException {

        int tokenLength = 0; //in case no length is known
        if(offendingSymbol != null) {
            if (offendingSymbol instanceof Token) {
                tokenLength = ((Token) offendingSymbol).getText().length();
            } else {
                tokenLength = offendingSymbol.toString().length();
            }
        }

        String error = String.format("syntax error at %d:%d: %s. msg: %s", line, charPositionInLine, offendingSymbol, msg);
        errors.addError(error);
        throw new AQLValidationException(msg, line, charPositionInLine, tokenLength);
    }

}
