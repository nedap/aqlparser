package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;

import java.util.ArrayList;
import java.util.List;

public class ValueList extends QOMObject {

    private List<PrimitiveOperand> items;

    public ValueList(AQLParser.ValueListContext ctx, Lookup lookup) {
        items = new ArrayList<>();
        List<QOMObject> objects = QOMParserUtil.parse(lookup, ctx.primitiveOperand().toArray(new AQLParser.PrimitiveOperandContext[0]));
        objects.forEach(object -> items.add((PrimitiveOperand) object));
    }

    @Override
    public void validate() {

    }

    public List<PrimitiveOperand> getItems() {
        return items;
    }

    public PrimitiveOperand item(Integer i) {
        return items.get(i);
    }

}
