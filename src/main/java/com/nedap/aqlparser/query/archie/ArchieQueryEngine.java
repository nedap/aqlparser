package com.nedap.aqlparser.query.archie;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.WhereClause;
import com.nedap.aqlparser.model.leaf.*;
import com.nedap.aqlparser.query.NodeExpressionEvaluator;
import com.nedap.aqlparser.query.QueryEngine;
import com.nedap.archie.query.RMPathQuery;
import com.nedap.archie.rm.RMObject;
import com.nedap.archie.rminfo.ArchieRMInfoLookup;

import java.util.stream.Collectors;

public class ArchieQueryEngine extends QueryEngine {

    public ArchieQueryEngine(String aql, ArchieQueryInterface queryInterface) throws AQLValidationException {
        super(aql,queryInterface);
    }

    public void where() {
        WhereClause whereClause = queryClause.getWhereClause();
        if (whereClause == null) return;

        NodeExpressionEvaluator evaluator = new NodeExpressionEvaluator() {
            @Override
            protected Boolean evaluateLeaf(Leaf leaf) {
                return ((IdentifiedExprOperand) leaf).evaluate(rmObject);
            }
        };

        ((ArchieQueryInterface) queryInterface).setRmObjects(
                ((ArchieQueryInterface) queryInterface).getRmObjects().stream().
                filter(rmObject -> evaluator.evaluate(whereClause.getIdentifiedExpression(),rmObject)).
                collect(Collectors.toList()));

    }

    private Object getObjectAtPath(RMObject rmObject,String path) {
        return new RMPathQuery(path).find(ArchieRMInfoLookup.getInstance(),rmObject);
    }





}
