package com.nedap.healthcare.aqlparser.parser;

import com.nedap.archie.antlr.errors.ANTLRParserErrors;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

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

        String error = String.format("syntax error at %d:%d: %s. msg: %s", line, charPositionInLine, offendingSymbol, msg);
        String offendingSymbolString = offendingSymbol.toString();
        errors.addError(error, msg, line, charPositionInLine, offendingSymbolString.length(), offendingSymbolString);
    }

    public ANTLRParserErrors getErrors() {
        return errors;
    }

}
