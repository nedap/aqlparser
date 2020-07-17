package com.nedap.healthcare.aqlparser.exception;

public class AQLValidationException extends RuntimeException {
    public AQLValidationException(String msg) {
        super(msg);
    }
}
