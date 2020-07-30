package com.nedap.healthcare.aqlparser.model;

import java.util.List;

public abstract class QOMObject {

    public abstract List<AQLValidationMessage> validate();

}
