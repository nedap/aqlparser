package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.Lookup;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArchetypePredicateExprTest {

    @Test
    public void archetypeId() throws AQLValidationException {
        String aql = "openEHR-EHR-COMPOSITION.test.v1.0.0";
        ArchetypeId archetypeId = (ArchetypeId) QOMParser.parse(aql,"archetypePredicateExpr");
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0",archetypeId.getArchetypeId());
    }

    @Test
    public void parameter() throws AQLValidationException {
        Lookup.addParameter("$someParameter",42);
        String aql = "$someParameter";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"archetypePredicateExpr");
        assertEquals(42,primitiveOperand.getValue());
    }

    @Test
    public void regexPattern() throws AQLValidationException {
        String aql = "{/\\s+/}";
        RegexPattern regexPattern = (RegexPattern) QOMParser.parse(aql,"archetypePredicateExpr");
        assertEquals("{/\\s+/}",regexPattern.getPattern());
    }
}
