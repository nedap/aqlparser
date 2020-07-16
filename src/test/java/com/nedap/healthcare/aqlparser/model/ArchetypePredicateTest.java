package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Predicate;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArchetypePredicateTest extends BaseTest {

    @Test
    public void archetypePredicate() throws AQLValidationException {
        String aql = "[openEHR-EHR-COMPOSITION.test.v1.0.0]";
        Predicate archetypePredicate = (Predicate) QOMParser.parse(aql,"archetypePredicate", lookup);
        assertEquals("[openEHR-EHR-COMPOSITION.test.v1.0.0]",archetypePredicate.toString());
    }

}
