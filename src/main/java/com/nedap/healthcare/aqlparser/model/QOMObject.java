package com.nedap.healthcare.aqlparser.model;


import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public abstract class QOMObject {

    public abstract void validate() throws AQLValidationException;

    public static <T extends QOMObject, Q extends ParseTree> T getInstance(Class<T> clazz, Q parseTree, Lookup lookup) {
        try {
            Constructor<T> constructor = clazz.getConstructor(ParseTree.class,Lookup.class);
            return constructor.newInstance(parseTree,lookup);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("Could not parse " + clazz.getCanonicalName());
        }
    }

}
