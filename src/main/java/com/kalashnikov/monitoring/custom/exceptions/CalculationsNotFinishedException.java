package com.kalashnikov.monitoring.custom.exceptions;

import java.io.IOException;

/**
 * Created by Aquila on 25.10.2015.
 */
public class CalculationsNotFinishedException extends IOException {

    /*
    Constructs a new exception with null as its detail message.
     */
    public CalculationsNotFinishedException() {
        super();
    }

    /*
    Constructs a new exception with the specified detail message.
     */
    public CalculationsNotFinishedException(String message) {
        super(message);
    }

    /*
    Constructs a new exception with the specified detail message and cause.
     */
    public CalculationsNotFinishedException(String message, Throwable cause) {
        super(message, cause);
    }

    /*
    Constructs a new exception with the specified cause and a detail
    message of (cause==null ? null : cause.toString())
   (which typically contains the class and detail message of cause).
     */
    public CalculationsNotFinishedException(Throwable cause) {
        super(cause);
    }
}

