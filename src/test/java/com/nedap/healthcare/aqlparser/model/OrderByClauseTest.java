package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.IdentifiedPath;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderByClauseTest {

    @Test
    public void orderByExpr() throws AQLValidationException {
        Lookup.addAlias("orderByAlias", (IdentifiedPath) QOMParser.parse("c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude","identifiedPath"));
        String aql = "ORDER BY orderByAlias";
        OrderByClause orderByClause = (OrderByClause) QOMParser.parse(aql,"orderByClause");
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByClause.getOrderByExpression(0).getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.DESCENDING,orderByClause.getOrderByExpression(0).getOrder());
    }

    @Test
    public void orderByMultiple() throws AQLValidationException {
        Lookup.addAlias("orderByAlias1", (IdentifiedPath) QOMParser.parse("c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude","identifiedPath"));
        Lookup.addAlias("orderByAlias2", (IdentifiedPath) QOMParser.parse("c/content[id0.0.100.1]/data[id3]/events[id4]/time/value","identifiedPath"));
        String aql = "ORDER BY orderByAlias1 DESC, orderByAlias2 ASC";
        OrderByClause orderByClause = (OrderByClause) QOMParser.parse(aql,"orderByClause");
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByClause.getOrderByExpression(0).getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.DESCENDING,orderByClause.getOrderByExpression(0).getOrder());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/time/value",orderByClause.getOrderByExpression(1).getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.ASCENDING,orderByClause.getOrderByExpression(1).getOrder());
    }
}
