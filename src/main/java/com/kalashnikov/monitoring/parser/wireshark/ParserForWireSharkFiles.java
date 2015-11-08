package com.kalashnikov.monitoring.parser.wireshark;


import java.io.BufferedReader;
import java.io.IOException;

class ParserForWireSharkFiles  {
    private BufferedReader bufferedReader;
    private final String REGEX = "^No\\. +Time +Source +Destination +Protocol +$";
    public static final int ERROR_VALUE = -2;
    public static final int END_OF_FILE_VALUE = -1;
    private final String FIRST_PACKAGE_INITIALIZATION = "firstPackage";
    private String firstPackage;
    private int globalCounter;
    private HelperToTheParser helper;

    ParserForWireSharkFiles (HelperToTheParser helper, BufferedReader bufferedReader) {
        this.helper = helper;
        this.bufferedReader = bufferedReader;
        this.firstPackage = helper.getFirstPackage();
    }


    public void setHelperWithNumberOfPackages() {
        double t = helper.getMaximumTime();
        int flag = 0;
        int counter;
        String line;
        double time;
        if (firstPackage == null) {
            System.out.println("End of file");
            helper.setNumberOfPackages(END_OF_FILE_VALUE);
            return;
        }
        if (firstPackage.equals(FIRST_PACKAGE_INITIALIZATION)) {
            firstPackage = getFirstPackage();
        }
        if (!checkFirstPackage(firstPackage, t)) {
            helper.setFirstPackage(firstPackage);
            helper.setNumberOfPackages(0);
            return;
        }
        counter = globalCounter;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (flag != 0) {
                    time = getTime(line);
                    if (time < t) {
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
            helper.setFirstPackage(line);
            globalCounter = 0;
            helper.setNumberOfPackages(counter);
        } catch (IOException e) {
            e.printStackTrace();
            helper.setNumberOfPackages(ERROR_VALUE);
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
            firstPackage = line;
            return null; //log
        } catch (IOException e) {
            e.printStackTrace();
            return null; //log
        }

    }


    HelperToTheParser getHelper() {
        return helper;
    }

}

