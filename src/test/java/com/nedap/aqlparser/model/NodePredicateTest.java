package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.expression.operand.NodeIdOperand;
import com.nedap.aqlparser.model.expression.operand.Operand;
import com.nedap.aqlparser.model.expression.operand.OperandType;
import com.nedap.aqlparser.model.expression.predicate.NodePredicate;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;


import static org.junit.Assert.*;

public class NodePredicateTest {

    @Test
    public void node_predicate_node_id() {
        String aql = "[at0042]";
        NodePredicate nodePredicate = (NodePredicate) QOMParser.parse(aql,"nodePredicate");
        assertTrue(nodePredicate.getLeftOperand() instanceof NodeIdOperand);
        NodeIdOperand operand = (NodeIdOperand) nodePredicate.getLeftOperand();
        assertEquals("at0042",operand.getValue());
    }

    @Test
    public void node_predicate_parameter() {
        String aql = "[$nodeId]";
        NodePredicate nodePredicate = (NodePredicate) QOMParser.parse(aql,"nodePredicate");
        Operand operand = (Operand) nodePredicate.getLeftOperand();
        assertEquals(OperandType.PARAMETER,operand.getType());
        assertEquals("$nodeId",operand.getValue());
    }

}
