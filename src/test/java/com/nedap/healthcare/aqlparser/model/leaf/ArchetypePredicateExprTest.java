package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArchetypePredicateExprTest extends BaseTest {

    @Test
    public void archetypeId() throws AQLValidationException {
        String aql = "openEHR-EHR-COMPOSITION.test.v1.0.0";
        ArchetypeId archetypeId = (ArchetypeId) QOMParser.parse(aql,"archetypePredicateExpr", lookup);
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0",archetypeId.getArchetypeId());
    }

    @Test
    public void parameter() throws AQLValidationException {
        lookup.addParameter("$someParameter",42);
        String aql = "$someParameter";
        PrimitiveOperand primitiveOperand = (PrimitiveOperand) QOMParser.parse(aql,"archetypePredicateExpr",lookup);
        assertEquals(42,primitiveOperand.getValue());
    }

}
