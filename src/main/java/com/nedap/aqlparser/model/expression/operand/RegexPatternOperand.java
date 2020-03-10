package com.nedap.aqlparser.model.expression.operand;

public class RegexPatternOperand extends Operand {

    public RegexPatternOperand(String pattern) {
        super(OperandType.STRING, pattern);
    }
}
