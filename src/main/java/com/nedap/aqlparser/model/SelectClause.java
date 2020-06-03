package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.SelectOperand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectClause extends QOMObject {

    private TopClause topClause;
    private List<SelectOperand> selection;

    public SelectClause(AQLParser.SelectClauseContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.SelectClauseContext ctx) {
        if (ctx.topClause() != null) topClause = new TopClause(ctx.topClause());
        selection = new ArrayList<>();
        ctx.selectOperand().forEach(selectOperandContext -> selection.add(new SelectOperand(selectOperandContext)));
    }

    @Override
    public void validate() throws AQLValidationException {
        if (topClause != null) topClause.validate();
        for (SelectOperand selectOperand : selection) {
            selectOperand.validate();
        }
    }

    public List<SelectOperand> getSelection() {
        return selection;
    }

    public SelectOperand getSelectOperand(String variableName) {
        List<SelectOperand> result = getByVariableName(variableName);
        return result.isEmpty() ? null : getByVariableName(variableName).get(0);
    }

    private List<SelectOperand> getByVariableName(String variableName) {
        return selection.stream().filter(selectOperand -> selectOperand.getIdentifiedPath().getVariableName().
                equals(variableName)).collect(Collectors.toList());
    }

    public TopClause getTopClause() {
        return topClause;
    }
}
