package com.kalashnikov.monitoring.exceptions;

public class MSExceptionExample extends MSException {

    public MSExceptionExample() {
        super();
    }

    public MSExceptionExample(String message) {
        super(message);
    }

    public MSExceptionExample(String message, Throwable cause) {
        super(message, cause);
    }

    public MSExceptionExample(Throwable cause) {
        super(cause);
    }
}
