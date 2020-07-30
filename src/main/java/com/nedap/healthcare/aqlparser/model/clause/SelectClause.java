package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.leaf.SelectOperand;

import java.util.ArrayList;
import java.util.List;

public class SelectClause extends QOMObject {

    private TopClause topClause;
    private List<SelectOperand> selection;

    public SelectClause(AQLParser.SelectClauseContext ctx, Lookup lookup) {
        if (ctx.topClause() != null) topClause = new TopClause(ctx.topClause());
        selection = new ArrayList<>();
        ctx.selectOperand().forEach(selectOperandContext -> selection.add(new SelectOperand(selectOperandContext, lookup)));
    }

    @Override
    public List<AQLValidationMessage> validate() {
        List<AQLValidationMessage> messages = new ArrayList<>();
        if (topClause != null) messages.addAll(topClause.validate());
        for (SelectOperand selectOperand : selection) {
            messages.addAll(selectOperand.validate());
        }
        return messages;
    }

    public List<SelectOperand> getSelection() {
        return selection;
    }

    public TopClause getTopClause() {
        return topClause;
    }
}
