package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.Direction;
import com.nedap.aqlparser.model.QOMObject;

public class TopClause extends QOMObject {

    private Integer nTop;
    private Direction direction;

    public TopClause(AQLParser.TopClauseContext ctx) {
        nTop = Integer.parseInt(ctx.INTEGER().getText());
        if (ctx.BACKWARD() != null) {
            direction = Direction.BACKWARD;
        } else {
            direction = Direction.FORWARD;
        }
    }

    public Integer getNTop() {
        return nTop;
    }

    public Direction getDirection() {
        return direction;
    }

}
