package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.exception.AQLUnsupportedFeatureException;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.time.temporal.Temporal;

public class Operator extends QOMObject {

    private final OperatorType type;

    public Operator(TerminalNode type) {
        this(OperatorType.get(type.getText()));
    }

    public Operator(OperatorType type) {
        this.type = type;
    }

    public OperatorType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public Boolean compare(Object o1, Object o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (!(o1 instanceof Comparable) || !(o2 instanceof Comparable)) {
            throw new IllegalArgumentException("Expected instance of Comparable");
        }

        //In AQL, you can either compare numbers, strings or dates. Any other object is not supported.
        if (o1 instanceof Number && o2 instanceof Number) {
            return compare(((Number) o1).doubleValue(), ((Number) o2).doubleValue());
        } else if (o1 instanceof String && o2 instanceof String) {
            //ToDo: In SQL, these operators compare position in alphabetic ordering. There is nothing about this in
            //      the AQL specs.
            if (type == OperatorType.GREATER_THAN ||
                    type == OperatorType.GREATER_EQUAL_TO ||
                    type == OperatorType.SMALLER_THAN ||
                    type == OperatorType.SMALLER_EQUAL_TO) {
                throw new AQLUnsupportedFeatureException(">, >=, <, <= operators not yet supported for comparison of Strings.");
            }
            return compare(o1.toString(), o2.toString());
        } else if (o1 instanceof Temporal && o2 instanceof Temporal){
            //ToDo: This will fail for certain combinations of o1 and o2! Cast dates to...?
            return compare((Comparable) o1, (Comparable) o2);
        } else {
            throw new IllegalArgumentException(
                    "Cannot compare " + o1.getClass().toGenericString() + " to " + o2.getClass().toGenericString());
        }
    }

    private <T extends Comparable<T>> Boolean compare(T left, T right) {
        switch (type) {
            case EQUAL:
            case MATCHES:
                return left.compareTo(right) == 0;
            case GREATER_THAN:
                return left.compareTo(right) > 0;
            case GREATER_EQUAL_TO:
                return left.compareTo(right) == 0 || left.compareTo(right) > 0;
            case SMALLER_THAN:
                return left.compareTo(right) < 0;
            case SMALLER_EQUAL_TO:
                return left.compareTo(right) == 0 || left.compareTo(right) < 0;
            case NOT_EQUAL:
                return left.compareTo(right) != 0;
            default:
                throw new IllegalArgumentException("Expected comparison operator");
        }
    }

    @Override
    public void validate() {

    }
}
