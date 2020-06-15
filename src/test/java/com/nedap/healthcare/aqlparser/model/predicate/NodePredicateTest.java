package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;


public class NodePredicateTest {

    @Test
    public void nodePredicate() throws AQLValidationException {
        String aql = "[id42]";
        NodePredicate nodePredicate = (NodePredicate) QOMParser.parse(aql,"nodePredicate");
        assertEquals("[id42]",nodePredicate.toString());
    }

}
