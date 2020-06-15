package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

public class RegexPattern extends QOMObject implements Leaf {

    private final String pattern;

    public RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public RegexPattern(TerminalNode pattern) {
        this(pattern.getText());
    }

    @Override
    public void validate() {

    }

    public String getPattern() {
        return pattern;
    }
}
