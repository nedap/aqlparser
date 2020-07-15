package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.OrderDirection;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrderByExprTest extends BaseTest {

    @Test
    public void identifiedPath() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        OrderByExpression orderByExpression = (OrderByExpression) QOMParser.parse(aql,"orderByExpr", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByExpression.getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.DESCENDING,orderByExpression.getOrder());
    }

    @Test
    public void identifiedPath_asc() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude ASC";
        OrderByExpression orderByExpression = (OrderByExpression) QOMParser.parse(aql,"orderByExpr", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByExpression.getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.ASCENDING,orderByExpression.getOrder());

        aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude ASCENDING";
        orderByExpression = (OrderByExpression) QOMParser.parse(aql,"orderByExpr", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByExpression.getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.ASCENDING,orderByExpression.getOrder());
    }

    @Test
    public void identifiedPath_desc() throws AQLValidationException {
        String aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude DESC";
        OrderByExpression orderByExpression = (OrderByExpression) QOMParser.parse(aql,"orderByExpr", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByExpression.getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.DESCENDING,orderByExpression.getOrder());

        aql = "c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude DESCENDING";
        orderByExpression = (OrderByExpression) QOMParser.parse(aql,"orderByExpr", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByExpression.getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.DESCENDING,orderByExpression.getOrder());
    }

    @Test
    public void identifiedPath_alias() throws AQLValidationException {
        lookup.addAlias("orderByAlias", (IdentifiedPath) QOMParser.parse("c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude","identifiedPath", lookup));
        String aql = "orderByAlias";
        OrderByExpression orderByExpression = (OrderByExpression) QOMParser.parse(aql,"orderByExpr", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByExpression.getIdentifiedPath().getObjectPath().toString());
        assertEquals(OrderDirection.DESCENDING,orderByExpression.getOrder());
    }
}
