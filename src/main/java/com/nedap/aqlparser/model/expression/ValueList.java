package com.nedap.aqlparser.model.expression;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.operand.Operand;

import java.util.ArrayList;
import java.util.List;

public class ValueList extends Leaf {

    private List<Operand> values;

    public ValueList(AQLParser.ValueListItemsContext ctx) {
        values = new ArrayList<>();
        for (AQLParser.OperandContext operandCtx : ctx.operand()) {
            values.add(new Operand(operandCtx));
        }
    }

    public List<Operand> getValues() {
        return values;
    }

}
