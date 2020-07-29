package com.nedap.healthcare.aqlparser.exception;

public class AQLValidationException extends RuntimeException {

    private String messageWithoutLineNumbers;
    private Integer lineNumber;
    private Integer charPosition;
    private Integer length;

    public AQLValidationException(String msg) {
        super(msg);
    }

    public AQLValidationException(String msg, int lineNumber, int charPosition, int length) {
        super("Line " +lineNumber + ":" + charPosition + " " + msg);
        this.lineNumber = lineNumber;
        this.charPosition = charPosition;
        this.length = length;
        this.messageWithoutLineNumbers = msg;
    }

    public AQLValidationException(String msg, Exception e) {
        super(msg, e);
    }

    public String getMessageWithoutLineNumbers() {
        return messageWithoutLineNumbers == null ? getMessage() : messageWithoutLineNumbers;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public Integer getCharPosition() {
        return charPosition;
    }

    public Integer getLength() {
        return length;
    }
}
