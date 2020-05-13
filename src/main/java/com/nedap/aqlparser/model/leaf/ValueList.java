package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.QOMObject;
import com.nedap.aqlparser.util.QOMParserUtil;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ValueList extends QOMObject implements Leaf {

    List<QOMObject> items;

    public ValueList(AQLParser.ValueListItemsContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.ValueListItemsContext ctx) {
        items = new ArrayList<>();
        items.addAll(QOMParserUtil.parse(ctx.primitiveOperand().toArray(new AQLParser.PrimitiveOperandContext[0])));
        items.addAll(QOMParserUtil.parse(ctx.PARAMETER().toArray(new TerminalNode[0])));
    }

}
