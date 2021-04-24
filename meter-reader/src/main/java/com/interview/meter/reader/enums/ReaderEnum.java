package com.interview.meter.reader.enums;

import java.util.EnumSet;

public interface ReaderEnum<T> {

    T getValue();

    T getCode();

    static <E extends Enum<E> & ReaderEnum<?>> E valueOf(Class<E> enumType, Object value) {
        EnumSet<E> enumValues = EnumSet.allOf(enumType);
        return enumValues.stream()
                .filter(x -> x.getValue().toString().equalsIgnoreCase(value.toString()))
                .findFirst()
                .orElse(null);
    }
}
