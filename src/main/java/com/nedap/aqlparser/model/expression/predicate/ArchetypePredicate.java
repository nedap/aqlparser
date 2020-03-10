package com.nedap.aqlparser.model.expression.predicate;


import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.Operator;
import com.nedap.aqlparser.model.expression.OperatorType;
import com.nedap.aqlparser.model.expression.operand.ArchetypeIdOperand;
import com.nedap.aqlparser.model.expression.operand.Operand;
import com.nedap.aqlparser.model.expression.operand.OperandType;

/**
 * An archetype predicate is a shortcut of a standard predicate, i.e. the predicate does not have the left operand
 * and operator. It only has an archetype id, e.g. [openEHR-EHR-COMPOSITION.encounter.v1]. The archetype predicate
 * is a specific type of query criterion indicating what archetype instances are relevant to this query. It is used
 * to scope the the data source from which the query expected data is to be retrieved.
 */
public class ArchetypePredicate extends Predicate {

    public ArchetypePredicate(AQLParser.ArchetypePredicateContext ctx) {
        if (ctx.ARCHETYPEID() != null) {
            this.rightOperand = new ArchetypeIdOperand(ctx.ARCHETYPEID().getText(), OperandType.STRING);
        } else if (ctx.PARAMETER() != null) {
            this.rightOperand = new ArchetypeIdOperand(ctx.PARAMETER().getText(), OperandType.PARAMETER);
        } else if (ctx.REGEXPATTERN() != null) {
            this.rightOperand = new ArchetypeIdOperand(ctx.REGEXPATTERN().getText(), OperandType.STRING);
        } else {
            throw new RuntimeException("MUST NOT BE REACHED");
        }
    }

    @Override
    public String toString(){
        return rightOperand.toString();
    }
}
