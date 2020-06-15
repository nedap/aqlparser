package com.nedap.healthcare.aqlparser.model;


import com.nedap.healthcare.aqlparser.exception.AQLValidationException;

public abstract class QOMObject {

    public abstract void validate() throws AQLValidationException;

}
