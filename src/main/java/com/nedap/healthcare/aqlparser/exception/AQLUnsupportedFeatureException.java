package com.nedap.healthcare.aqlparser.exception;

public class AQLUnsupportedFeatureException extends RuntimeException {

    public AQLUnsupportedFeatureException() {}

    public AQLUnsupportedFeatureException(String msg) {
        super(msg);
    }
}
