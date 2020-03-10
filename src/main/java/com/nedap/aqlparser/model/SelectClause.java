package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.IdentifiedPath;

import java.util.ArrayList;
import java.util.List;

public class SelectClause extends QOMObject {

    private TopClause top;
    private List<IdentifiedPath> selection;

    public SelectClause(AQLParser.SelectClauseContext ctx) {
        if (ctx.topClause() != null) top = new TopClause(ctx.topClause());
        selection = new ArrayList<>();
        for (AQLParser.SelectVarContext varContext : ctx.selectExpr().selectVar()) {
            IdentifiedPath identifiedPath = new IdentifiedPath(varContext.identifiedPath());
            if (varContext.AS() != null) {
                identifiedPath.setAlias(varContext.IDENTIFIER().getText());
            }
            selection.add(identifiedPath);
        }
    }

    public TopClause getTop() {
        return top;
    }

    public void setTop(TopClause top) {
        this.top = top;
    }

    public List<IdentifiedPath> getSelection() {
        return selection;
    }

    public void addToSelection(IdentifiedPath identifiedPath) {
        selection.add(identifiedPath);
    }

}
