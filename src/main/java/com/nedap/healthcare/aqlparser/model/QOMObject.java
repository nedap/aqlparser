package com.nedap.healthcare.aqlparser.model;

import java.util.ArrayList;
import java.util.List;


public abstract class QOMObject {

    private List<AQLValidationMessage> validationMessages;

    public abstract void validate();

    public void addValidationMessage(AQLValidationMessage message) {
        if (validationMessages == null) {
            validationMessages = new ArrayList<>();
        }
        validationMessages.add(message);
    }

    public List<AQLValidationMessage> getValidationMessages() {
        return validationMessages;
    }

    public Boolean hasErrors() {
        return validationMessages != null;
    }

}
