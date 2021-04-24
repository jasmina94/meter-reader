package com.interview.meter.reader.enums;

public enum Status implements ReaderEnum {
    PENDING(1, "PENDING"),
    ACTIVE(2, "ACTIVE"),
    DELETED(3, "DELETED");

    private int code;
    private String value;

    Status(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Object getCode() {
        return null;
    }
}
