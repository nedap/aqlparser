package com.nedap.healthcare.aqlparser.model;


import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public abstract class QOMObject {

    public abstract void validate() throws AQLValidationException;

}
