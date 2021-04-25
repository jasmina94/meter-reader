package com.interview.meter.reader.exception;

public class MRInternalException extends RuntimeException {

    public MRInternalException(String message) {
        super(message);
    }

    public MRInternalException(String message, Throwable cause) {
        super(message, cause);
    }
}
