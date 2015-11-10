package com.kalashnikov.monitoring.parser.wireshark;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

class ParserForWireSharkFiles {


    private static final Logger log = Logger.getLogger(ParserForWireSharkFiles.class);
    private BufferedReader bufferedReader;
    private final String REGEX = "^No\\. +Time +Source +Destination +Protocol +$";
    public static final int ERROR_VALUE = -2;
    public static final int END_OF_FILE_VALUE = -1;
    public static final String FIRST_PACKAGE_INITIALIZATION = "firstPackage";
    private String firstPackage;
    private String lastPackage;
    private double maxTime;
    private int globalCounter;


    ParserForWireSharkFiles(String firstPackage, double maxTime, BufferedReader bufferedReader) {
        this.firstPackage = firstPackage;
        this.maxTime = maxTime;
        this.bufferedReader = bufferedReader;

    }


    public int getNumberOfPackages() {
        int flag = 0;
        int counter;
        String line;
        double time;
        if (firstPackage == null) {
            return END_OF_FILE_VALUE;
        }
        if (firstPackage.equals(FIRST_PACKAGE_INITIALIZATION)) {
            firstPackage = getFirstPackage();
        }
        if (!checkFirstPackage(firstPackage, maxTime)) {
            lastPackage = firstPackage;
            return 0;
        }
        counter = globalCounter;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (flag != 0) {
                    time = getTime(line);
                    if (time < maxTime) {
                        counter++;
                        flag = 0;
                    } else {
                        break;
                    }
                }
                if (line.matches(REGEX)) {
                    flag++;
                }
            }
            lastPackage = line;
            return counter;
        } catch (IOException e) {
            log.error("Reading error",e);
            return ERROR_VALUE;
        }
    }

    private double getTime(String line) {
        String[] dividedString;
        dividedString = line.split(" +");
        return Double.parseDouble(dividedString[2]);
    }

    private boolean checkFirstPackage(String line, double interval) {
        double time = getTime(line);
        if (time < interval) {
            globalCounter++;
            return true;
        }
        return false;
    }

    private String getFirstPackage() {
        String line;
        int flag = 0;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (flag != 0) {
                    return line;
                }
                if (line.matches(REGEX)) {
                    flag++;
                }
            }
            return line; //line = null
        } catch (IOException e) {
            log.error("Reading error",e);
            return null;
        }

    }

    public String getLastPackage() {
        return lastPackage;
    }
}

