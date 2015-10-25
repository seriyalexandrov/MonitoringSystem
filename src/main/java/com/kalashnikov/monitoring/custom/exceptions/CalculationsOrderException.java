package com.kalashnikov.monitoring.custom.exceptions;

/**
 * Created by Aquila on 25.10.2015.
 */
public class CalculationsOrderException extends InterruptedException {

    /*
    Constructs a new exception with null as its detail message.
     */
    public CalculationsOrderException() {
        super();
    }

    /*
    Constructs a new exception with the specified detail message.
     */
    public CalculationsOrderException(String message) {
        super(message);
    }
}

