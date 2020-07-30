package com.nedap.healthcare.aqlparser.model;

public class AQLValidationMessage {

    private Class<?> clazz;

    private String message;

    public AQLValidationMessage(Class<?> clazz, String message) {
        this.clazz = clazz;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return clazz.getSimpleName() + ": " + message;
    }
}
