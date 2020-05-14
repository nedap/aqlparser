package com.nedap.aqlparser.model;


import com.nedap.aqlparser.exception.AQLValidationException;

public abstract class QOMObject {

    public abstract void validate() throws AQLValidationException;

}
