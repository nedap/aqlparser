package com.nedap.healthcare.aqlparser.exception;

public class AQLValidationException extends RuntimeException {

    public AQLValidationException(String msg) {
        super(msg);
    }

    public AQLValidationException(String msg, Exception e) {
        super(msg, e);
    }
}
