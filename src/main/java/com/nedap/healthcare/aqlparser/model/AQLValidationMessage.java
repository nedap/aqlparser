package com.nedap.healthcare.aqlparser.model;

public class AQLValidationMessage {

    private String message;

    public AQLValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
