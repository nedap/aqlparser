package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.QOMObject;

public class Predicate extends QOMObject {

    protected QOMObject predicateExpression;

    @Override
    public String toString() {
        return "[" + predicateExpression.toString() + "]";
    }

    @Override
    public void validate() throws AQLValidationException {
        predicateExpression.validate();
    }

    public QOMObject getPredicateExpression() {
        return predicateExpression;
    }
}
