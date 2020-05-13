package com.nedap.aqlparser.query;

import com.nedap.aqlparser.model.QueryClause;
import com.nedap.aqlparser.parser.QOMParser;

public abstract class QueryEngine {

    protected QueryClause queryClause;

    protected QueryInterface queryInterface;

    public QueryEngine(String aql, QueryInterface queryInterface) {
        this.queryInterface = queryInterface;
        this.queryClause = QOMParser.parse(aql);
    }

}
