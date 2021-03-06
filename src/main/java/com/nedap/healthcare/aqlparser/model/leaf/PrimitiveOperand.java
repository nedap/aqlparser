package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.Temporal;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PrimitiveOperand extends QOMObject {

    private PrimitiveType type;

    private Object value;

    private Lookup lookup;

    public PrimitiveOperand(AQLParser.PrimitiveOperandContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public PrimitiveOperand(PrimitiveType type, String value, Lookup lookup) {
        this.lookup = lookup;
        this.type = type;
        this.value = castValueToType(value);
    }

    private void initialize(AQLParser.PrimitiveOperandContext ctx) {
        if (ctx.STRING() != null) {
            type =  PrimitiveType.STRING;
            value = castValueToType(ctx.STRING().getText());
        } else if (ctx.INTEGER() != null) {
            type =  PrimitiveType.INTEGER;
            value = castValueToType(ctx.INTEGER().getText());
        } else if (ctx.FLOAT() != null) {
            type =  PrimitiveType.FLOAT;
            value = castValueToType(ctx.FLOAT().getText());
        } else if (ctx.DATE() != null) {
            type =  PrimitiveType.DATE;
            value = castValueToType(ctx.DATE().getText());
        } else if (ctx.BOOLEAN() != null) {
            type = PrimitiveType.BOOLEAN;
            value = castValueToType(ctx.BOOLEAN().getText());
        } else if (ctx.PARAMETER() != null) {
            type = PrimitiveType.PARAMETER;
            value = castValueToType(ctx.PARAMETER().getText());
        } else {
            throw new IllegalArgumentException("Unknown operand type");
        }
    }

    private Object castValueToType(String value) {
        if (type == PrimitiveType.STRING) {
            String result = value;
            if (result.startsWith("'") || result.startsWith("\"")) {
                result = result.substring(1,result.length() - 1);
            }
            return result;
        } else if (type == PrimitiveType.INTEGER) {
            return Integer.parseInt(value);
        } else if (type == PrimitiveType.FLOAT) {
            return Float.parseFloat(value);
        } else if (type == PrimitiveType.DATE) {
            return parseDate(value);
        } else if (type == PrimitiveType.BOOLEAN) {
            return Boolean.parseBoolean(value);
        } else if (type == PrimitiveType.PARAMETER) {
            PrimitiveOperand result = lookup.getParameter(value);
            if (result == null) {
                throw new AQLValidationException("Could not resolve parameter " + value);
            }
            return result.getValue();
        } else {
            throw new IllegalArgumentException("Unknown operand type");
        }
    }

    public PrimitiveType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public List<AQLValidationMessage> validate() {
        return Collections.emptyList();
    }

    private Temporal parseDate(String date) {
        Pattern dateTimePattern = Pattern.compile(
                "(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})((\\s|T)+(?<hour>\\d{2}):(?<minute>\\d{2})(:(?<second>\\d{2}))?(\\+(?<offsetHour>\\d{2}):(?<offsetMinute>\\d{2}))?)?");
        Matcher m = dateTimePattern.matcher(date);
        if(!m.matches()) {
            throw new IllegalArgumentException(date + " is not a valid date");
        }
        int year = Integer.parseInt(m.group("year"));
        int month = Integer.parseInt(m.group("month"));
        int day = Integer.parseInt(m.group("day"));
        int hour = 0;
        if (m.group("hour") != null) {
            hour = Integer.parseInt(m.group("hour"));
        }
        int minute =0;
        if (m.group("minute") != null) {
            minute = Integer.parseInt(m.group("minute"));
        }
        int second = 0;
        if (m.group("second") != null) {
            second = Integer.parseInt(m.group("second"));
        }
        LocalDateTime localDateTime = LocalDateTime.of(year,month,day,hour,minute,second);
        if (m.group("offsetHour") != null) {
            int offsetHour = Integer.parseInt(m.group("offsetHour"));
            int offsetMinute = Integer.parseInt(m.group("offsetMinute"));
            return OffsetDateTime.of(localDateTime,ZoneOffset.ofHoursMinutes(offsetHour,offsetMinute));
        } else {
            return localDateTime;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof PrimitiveOperand)) {
            return false;
        }
        PrimitiveOperand other = (PrimitiveOperand) o;
        if (!other.getType().isAssignableFrom(this.getType())) {
            return false;
        }
        return other.getValue() == this.getValue();
    }

}
