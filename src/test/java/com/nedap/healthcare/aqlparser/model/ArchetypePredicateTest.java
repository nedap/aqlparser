package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class ArchetypePredicateTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void archetypePredicate() throws AQLValidationException {
        String aql = "[openEHR-EHR-COMPOSITION.test.v1.0.0]";
        Predicate archetypePredicate = (Predicate) QOMParser.parse(aql,"archetypePredicate", lookup);
        assertEquals("[openEHR-EHR-COMPOSITION.test.v1.0.0]",archetypePredicate.toString());
    }

    @Test
    public void invalidParameter() throws AQLValidationException {
        lookup.addParameter("$archetypeId",42);
        String aql = "[$archetypeId]";

        thrown.expect(AQLValidationException.class);
        thrown.expectMessage("Expected Parameter $archetypeId in " +
                "ArchetypePredicate to be of type STRING");
        QOMParser.parse(aql,"archetypePredicate", lookup);
    }

    @Test
    public void invalidArchetypeId() throws AQLValidationException {
        lookup.addParameter("$archetypeId","'someId'");
        String aql = "[$archetypeId]";

        thrown.expect(AQLValidationException.class);
        thrown.expectMessage("someId is not a valid archetype human readable id.");
        QOMParser.parse(aql,"archetypePredicate", lookup);
    }

}
