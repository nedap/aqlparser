package com.nedap.healthcare.aqlparser.exception;

import com.nedap.archie.antlr.errors.ANTLRParserErrors;

public class AQLParsingException extends RuntimeException {

    private final ANTLRParserErrors errors;

    public AQLParsingException(ANTLRParserErrors errors) {
        super("Could not parse QOM: \n" + errors.toString());
        this.errors = errors;
    }

    public ANTLRParserErrors getErrors() {
        return errors;
    }

}
