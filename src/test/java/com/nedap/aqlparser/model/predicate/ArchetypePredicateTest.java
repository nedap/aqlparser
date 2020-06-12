package com.nedap.aqlparser.model.predicate;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArchetypePredicateTest {

    @Test
    public void archetypePredicate() throws AQLValidationException {
        String aql = "[openEHR-EHR-COMPOSITION.test.v1.0.0]";
        ArchetypePredicate archetypePredicate = (ArchetypePredicate) QOMParser.parse(aql,"archetypePredicate");
        assertEquals("[openEHR-EHR-COMPOSITION.test.v1.0.0]",archetypePredicate.toString());
    }

}
