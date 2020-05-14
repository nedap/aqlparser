package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.QOMObject;
import com.nedap.aqlparser.util.QOMParserUtil;
import com.nedap.archie.rm.RMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ValueList extends QOMObject implements Leaf {

    private List<PrimitiveOperand> items;

    public ValueList(AQLParser.ValueListItemsContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ValueListItemsContext ctx) {
        items = new ArrayList<>();
        List<QOMObject> objects = QOMParserUtil.parse(ctx.primitiveOperand().toArray(new AQLParser.PrimitiveOperandContext[0]));
        objects.forEach(object -> items.add((PrimitiveOperand) object));
    }

    @Override
    public void validate() {

    }

    public List<PrimitiveOperand> getItems() {
        return items;
    }

}
