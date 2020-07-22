package com.nedap.healthcare.aqlparser.parser;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class QOMErrorListener extends BaseErrorListener {

    public static QOMErrorListener getInstance() {
        return new QOMErrorListener();
    }

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg, RecognitionException e) throws AQLValidationException {
        throw new AQLValidationException("Line " + line + ":" + charPositionInLine + " " + msg);
    }

}
