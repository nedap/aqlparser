package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodePredicateExprOperandTest {

    @Test
    public void nodeId() throws AQLValidationException {
        String aql ="id42";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof NodeId);
        assertEquals("id42", ((NodeId) nodePredicateExprOperand.getObject()).getNodeId());
    }

    @Test
    public void nodeId_string() throws AQLValidationException {
        String aql ="id42, 'someString'";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("id42", ((NodeId) nodePredicateExprOperand.getChildren(0).getObject()).getNodeId());
        assertEquals("someString", ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void nodeId_parameter() throws AQLValidationException {
        Lookup.addParameter("$someParameter", 42);
        String aql ="id42, $someParameter";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("id42", ((NodeId) nodePredicateExprOperand.getChildren(0).getObject()).getNodeId());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void archetypeId() throws AQLValidationException {
        String aql ="openEHR-EHR-COMPOSITION.test.v1.0.0";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof ArchetypeId);
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0", ((ArchetypeId) nodePredicateExprOperand.getObject()).getArchetypeId());
    }

    @Test
    public void archetypeId_string() throws AQLValidationException {
        String aql ="openEHR-EHR-COMPOSITION.test.v1.0.0, 'someString'";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0", ((ArchetypeId) nodePredicateExprOperand.getChildren(0).getObject()).getArchetypeId());
        assertEquals("someString", ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void archetypeId_parameter() throws AQLValidationException {
        Lookup.addParameter("$someParameter", 42);
        String aql ="openEHR-EHR-COMPOSITION.test.v1.0.0, $someParameter";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0", ((ArchetypeId) nodePredicateExprOperand.getChildren(0).getObject()).getArchetypeId());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void parameter() throws AQLValidationException {
        Lookup.addParameter("$someParameter", 42);
        String aql ="$someParameter";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertTrue(nodePredicateExprOperand.getObject() instanceof PrimitiveOperand);
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getObject()).getValue());
    }

    @Test
    public void parameter_string() throws AQLValidationException {
        Lookup.addParameter("$someParameter", 42);
        String aql ="$someParameter, 'someString'";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(0).getObject()).getValue());
        assertEquals("someString", ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void parameter_parameter() throws AQLValidationException {
        Lookup.addParameter("$someParameter", 42);
        Lookup.addParameter("$someOtherParameter", 1909);
        String aql ="$someParameter, $someOtherParameter";
        NodePredicateExprOperand nodePredicateExprOperand = (NodePredicateExprOperand) QOMParser.parse(aql,"nodePredicateExprOperand");
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(0).getObject()).getValue());
        assertEquals(1909, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

}
