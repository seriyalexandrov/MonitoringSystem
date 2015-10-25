package com.kalashnikov.monitoring.exceptions;

public class MSException extends Exception {

    /*
    Constructs a new exception with null as its detail message.
     */
    public MSException() {
        super();
    }

    /*
    Constructs a new exception with the specified detail message.
     */
    public MSException(String message) {
        super(message);
    }

    /*
    Constructs a new exception with the specified detail message and cause.
     */
    public MSException(String message, Throwable cause) {
        super(message, cause);
    }

    /*
    Constructs a new exception with the specified cause and a detail
    message of (cause==null ? null : cause.toString())
   (which typically contains the class and detail message of cause).
     */
    public MSException(Throwable cause) {
        super(cause);
    }
}
