package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.model.QOMObject;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class Operator extends QOMObject implements Leaf {

    private final OperatorType type;

    public Operator(TerminalNode type) {
        this(OperatorType.get(type.getText()));
    }

    public Operator(OperatorType type) {
        this.type = type;
    }

    public Operator(String type) {
        this.type = OperatorType.get(type);
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
            throw new RuntimeException("Expected instance of Comparable");
        }

        //In AQL, you can either compare numbers, strings or dates. Any other object is not supported.
        //ToDo: Compare also dates
        if (o1 instanceof Number && o2 instanceof Number) {
            return compare(((Number) o1).doubleValue(), ((Number) o2).doubleValue());
        } else if (o1 instanceof String && o2 instanceof String) {
            return compare(o1.toString(), o2.toString());
        } else if (o1 instanceof LocalDateTime && o2 instanceof LocalDateTime) {
            return compare((LocalDateTime) o1, (LocalDateTime) o2);
        } else if (o1 instanceof OffsetDateTime && o2 instanceof OffsetDateTime) {
            return compare((OffsetDateTime) o1, (OffsetDateTime) o2);
        } else {
            throw new RuntimeException(
                    "Cannot compare " + o1.getClass().toGenericString() + " to " + o2.getClass().toGenericString());
        }
    }

    public <T extends Comparable<T>> Boolean compare(T left, T right) {
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
                throw new RuntimeException("Expected comparison operator");
        }
    }

    @Override
    public void validate() {

    }
}
