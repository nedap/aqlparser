package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.SelectOperand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectClause extends QOMObject {

    private List<SelectOperand> selection;

    public SelectClause(AQLParser.SelectClauseContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.SelectClauseContext ctx) {
        selection = new ArrayList<>();
        ctx.selectOperand().forEach(selectOperandContext -> selection.add(new SelectOperand(selectOperandContext)));
    }

    @Override
    public void validate() throws AQLValidationException {
        for (SelectOperand selectOperand : selection) {
            selectOperand.validate();
            if (getByVariableName(selectOperand.getIdentifiedPath().getVariableName()).size() > 1) {
                throw new AQLValidationException("Duplicate variable name " + selectOperand.getIdentifiedPath().getVariableName());
            }
        }
    }

    public List<SelectOperand> getSelection() {
        return selection;
    }

    public SelectOperand getSelectOperand(String variableName) {
        return getByVariableName(variableName).get(0);
    }

    private List<SelectOperand> getByVariableName(String variableName) {
        return selection.stream().filter(selectOperand -> selectOperand.getIdentifiedPath().getVariableName().
                equals(variableName)).collect(Collectors.toList());
    }
}
