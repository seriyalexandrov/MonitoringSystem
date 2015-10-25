package com.kalashnikov.monitoring.custom.exceptions;

/**
 * Created by Aquila on 25.10.2015.
 */
public class ConfigurationIncorrectLoading extends Exception {

    /*
    Constructs a new exception with null as its detail message.
     */
    public ConfigurationIncorrectLoading() {
        super();
    }

    /*
    Constructs a new exception with the specified detail message.
     */
    public ConfigurationIncorrectLoading(String message) {
        super(message);
    }

    /*
    Constructs a new exception with the specified detail message and cause.
     */
    public ConfigurationIncorrectLoading(String message, Throwable cause) {
        super(message, cause);
    }

    /*
    Constructs a new exception with the specified cause and a detail
    message of (cause==null ? null : cause.toString())
   (which typically contains the class and detail message of cause).
     */
    public ConfigurationIncorrectLoading(Throwable cause) {
        super(cause);
    }
}
