package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodePredicateExprOperandTest extends BaseTest {

    @Test
    public void nodeId() throws AQLValidationException {
        String aql ="id42";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof TerminalNodeLeaf);
        assertEquals("id42", ((TerminalNodeLeaf) nodePredicateExprOperand.getObject()).getValue());
    }

    @Test
    public void nodeId_string() throws AQLValidationException {
        String aql ="id42, 'someString'";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("id42", ((TerminalNodeLeaf) nodePredicateExprOperand.getChildren(0).getObject()).getValue());
        assertEquals("someString", ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void nodeId_parameter() throws AQLValidationException {
        lookup.addParameter("$someParameter", 42);
        String aql ="id42, $someParameter";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("id42", ((TerminalNodeLeaf) nodePredicateExprOperand.getChildren(0).getObject()).getValue());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void archetypeId() throws AQLValidationException {
        String aql ="openEHR-EHR-COMPOSITION.test.v1.0.0";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof ArchetypeId);
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0", ((ArchetypeId) nodePredicateExprOperand.getObject()).getArchetypeId());
    }

    @Test
    public void archetypeId_string() throws AQLValidationException {
        String aql ="openEHR-EHR-COMPOSITION.test.v1.0.0, 'someString'";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0", ((ArchetypeId) nodePredicateExprOperand.getChildren(0).getObject()).getArchetypeId());
        assertEquals("someString", ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void archetypeId_parameter() throws AQLValidationException {
        lookup.addParameter("$someParameter", 42);
        String aql ="openEHR-EHR-COMPOSITION.test.v1.0.0, $someParameter";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof Operator);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals("openEHR-EHR-COMPOSITION.test.v1.0.0", ((ArchetypeId) nodePredicateExprOperand.getChildren(0).getObject()).getArchetypeId());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void parameter() throws AQLValidationException {
        lookup.addParameter("$someParameter", 42);
        String aql ="$someParameter";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertTrue(nodePredicateExprOperand.getObject() instanceof PrimitiveOperand);
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getObject()).getValue());
    }

    @Test
    public void parameter_string() throws AQLValidationException {
        lookup.addParameter("$someParameter", 42);
        String aql ="$someParameter, 'someString'";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(0).getObject()).getValue());
        assertEquals("someString", ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void parameter_parameter() throws AQLValidationException {
        lookup.addParameter("$someParameter", 42);
        lookup.addParameter("$someOtherParameter", 1909);
        String aql ="$someParameter, $someOtherParameter";
        NodeExpression nodePredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"nodePredicateExprOperand", lookup);
        assertEquals( OperatorType.AND, ((Operator) nodePredicateExprOperand.getObject()).getType());
        assertEquals(42, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(0).getObject()).getValue());
        assertEquals(1909, ((PrimitiveOperand) nodePredicateExprOperand.getChildren(1).getObject()).getValue());
    }

}
