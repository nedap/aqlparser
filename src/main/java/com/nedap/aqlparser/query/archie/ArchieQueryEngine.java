package com.nedap.aqlparser.query.archie;

import com.nedap.aqlparser.model.WhereClause;
import com.nedap.aqlparser.model.leaf.*;
import com.nedap.aqlparser.query.NodeExpressionEvaluator;
import com.nedap.aqlparser.query.QueryEngine;
import com.nedap.archie.query.RMPathQuery;
import com.nedap.archie.rm.RMObject;
import com.nedap.archie.rminfo.ArchieRMInfoLookup;

import java.util.stream.Collectors;

public class ArchieQueryEngine extends QueryEngine {

    public ArchieQueryEngine(String aql, ArchieQueryInterface queryInterface) {
        super(aql,queryInterface);
    }

    public void where() {
        WhereClause whereClause = queryClause.getWhereClause();
        if (whereClause == null) return;

        NodeExpressionEvaluator evaluator = new NodeExpressionEvaluator() {
            @Override
            protected Boolean evaluateLeaf(Leaf leaf) {
                IdentifiedExprOperand identifiedExprOperand = (IdentifiedExprOperand) leaf;
                //ToDo: Add validation of object!
                Object o1 = getObjectAtPath(rmObject, identifiedExprOperand.getChildren(0).toString());

                //ToDo: Refactor!
                //ToDo: What about matches operand?
                PredicateOperand operand = (PredicateOperand) identifiedExprOperand.getChildren(1).getObject();

                Object o2;
                if (operand.getOperand() instanceof ObjectPath) {
                    o2 = getObjectAtPath(rmObject, operand.toString());
                } else if (operand.getOperand() instanceof PrimitiveOperand) {
                    o2 = ((PrimitiveOperand) operand.getOperand()).getValue();
                } else if (operand.getOperand() instanceof Parameter) {
                    o2 = ((PrimitiveOperand) operand.getOperand()).getValue();
                } else {
                    throw new RuntimeException();
                }

                Operator operator = (Operator) identifiedExprOperand.getObject();
                return operator.compare(o1, o2);
            }
        };

        ((ArchieQueryInterface) queryInterface).setRmObjects(
                ((ArchieQueryInterface) queryInterface).getRmObjects().stream().
                filter(rmObject -> evaluator.evaluate(whereClause.getIdentifiedExpression(),rmObject)).
                collect(Collectors.toList()));

    }

    private Object getObjectAtPath(RMObject rmObject,String path) {
        RMPathQuery query = new RMPathQuery(path);
        return query.find(ArchieRMInfoLookup.getInstance(),rmObject);
    }





}
