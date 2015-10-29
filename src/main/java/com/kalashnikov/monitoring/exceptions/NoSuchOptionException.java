package com.kalashnikov.monitoring.exceptions;

public class NoSuchOptionException extends MSException {

    public NoSuchOptionException() {
        super();
    }

    public NoSuchOptionException(String message) {
        super(message);
    }

    public NoSuchOptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchOptionException(Throwable cause) {
        super(cause);
    }

}