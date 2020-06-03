package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;

public class TopClause extends QOMObject {

    private Integer limit;
    private TopDirection direction;

    public TopClause(AQLParser.TopClauseContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.TopClauseContext ctx) {
        limit = Integer.parseInt(ctx.INTEGER().getText());
        direction = TopDirection.FORWARD;
        if (ctx.BACKWARD() != null) direction = TopDirection.BACKWARD;
    }


    @Override
    public void validate() throws AQLValidationException {

    }

    public Integer getLimit() {
        return limit;
    }

    public TopDirection getDirection() {
        return direction;
    }
}
