package com.kalashnikov.monitoring;

import org.apache.log4j.Logger;

public class SystemExecutor {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);

    public static void main(String[] args) {

        log.info("This is informative message!");
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            log.error("This is an exception", e);
        }

    }

}