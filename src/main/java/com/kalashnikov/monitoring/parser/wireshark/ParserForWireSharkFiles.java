package com.kalashnikov.monitoring.parser.wireshark;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class ParserForWireSharkFiles {


    private static final Logger log = Logger.getLogger(ParserForWireSharkFiles.class);
    private BufferedReader bufferedReader;
    private final String REGEX = "^No\\. +Time +Source +Destination +Protocol +$";
    private static final int NUMBER_OF_USEFUL_STRINGS = 2;
    private static final String READING_ERROR = "Reading error";
    private static final String SLEEP_ERROR = "Sleeping error";
    private PackageFromWireShark firstPackage;
    private PackageFromWireShark lastPackage;
    private double maxTime;
    private double timeInterval;
    private final int MILLISECONDS_IN_SECOND = 1000;


    public ParserForWireSharkFiles(PackageFromWireShark firstPackage, double maxTime, BufferedReader bufferedReader, double timeInterval) {

        this.firstPackage = firstPackage;
        this.maxTime = maxTime;
        this.bufferedReader = bufferedReader;
        this.timeInterval = timeInterval;

    }


    public ArrayList<PackageFromWireShark> getArrayListOfPackages() {


        ArrayList<PackageFromWireShark> packages = new ArrayList<>();
        PackageFromWireShark pack = null;
        boolean stringLikeRegexpFlag = false;
        String line;
        double time;
        String[] stringsWithInformation = new String[NUMBER_OF_USEFUL_STRINGS];
        long startTime = System.currentTimeMillis();
        long currentTime;
        long sleepTime;
        if (firstPackage == null) {
            firstPackage = getFirstPackage();
        }

        if (firstPackage != null) {
            if (!checkFirstPackage(firstPackage, maxTime)) {
                lastPackage = firstPackage;
                try {
                    currentTime = System.currentTimeMillis();
                    sleepTime = (long) timeInterval * MILLISECONDS_IN_SECOND - (currentTime - startTime);
                    if (sleepTime > 0) {
                        Thread.sleep(sleepTime);
                    }
                } catch (InterruptedException e) {
                    log.error(SLEEP_ERROR+1, e);
                }
                return packages;
            }
            packages.add(firstPackage);
            firstPackage = null;
        }

        try {
            while ((line = bufferedReader.readLine()) != null) {

                if (stringLikeRegexpFlag) {

                    stringsWithInformation[0] = line;
                    bufferedReader.readLine();
                    stringsWithInformation[1] = bufferedReader.readLine();
                    pack = parseStrings(stringsWithInformation);
                    time = pack.getTime();

                    if (time < maxTime) {
                        packages.add(pack);
                        stringLikeRegexpFlag = false;
                    } else {
                        lastPackage = pack;
                        try {
                            currentTime = System.currentTimeMillis();
                            sleepTime = (long) timeInterval * MILLISECONDS_IN_SECOND - (currentTime - startTime);
                            if (sleepTime > 0) {
                                Thread.sleep(sleepTime);
                            }
                        } catch (InterruptedException e) {
                            log.error(SLEEP_ERROR+2, e);
                        }
                        return packages;
                    }
                }

                if (line.matches(REGEX)) {
                    stringLikeRegexpFlag = true;
                }
            }
        } catch (IOException e) {
            log.error(READING_ERROR+3, e);
            return null;
        }
        lastPackage = null;
        try {
            currentTime = System.currentTimeMillis();
            sleepTime = (long) timeInterval * MILLISECONDS_IN_SECOND - (currentTime - startTime);
            if (sleepTime > 0) {
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
           log.error(SLEEP_ERROR+4, e);
        }
        return packages;
    }

    private boolean checkFirstPackage(PackageFromWireShark pack, double interval) {

        double time = pack.getTime();
        if (time < interval) {
            return true;
        }
        return false;
    }

    private PackageFromWireShark getFirstPackage() {
        String[] stringsWithInformation = new String[NUMBER_OF_USEFUL_STRINGS];
        String line;
        boolean stringLikeRegexpFlag = false;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (stringLikeRegexpFlag) {
                    stringsWithInformation[0] = line;
                    bufferedReader.readLine();
                    line = bufferedReader.readLine();
                    stringsWithInformation[1] = line;
                    return parseStrings(stringsWithInformation);
                }
                if (line.matches(REGEX)) {
                    stringLikeRegexpFlag = true;
                }
            }
            log.error("Privet");
            return null;
        } catch (IOException e) {
            log.error(READING_ERROR+5, e);
            return null;
        }

    }

    private PackageFromWireShark parseStrings(String[] strings) {

        String information = strings[0];
        String[] dividedInformation = information.split(" +");
        PackageFromWireShark pack = new PackageFromWireShark(Integer.parseInt(dividedInformation[1]));
        pack.setTime(Double.parseDouble(dividedInformation[2]));
        pack.setSource(dividedInformation[3]);
        pack.setDestination(dividedInformation[4]);
        pack.setProtocol(dividedInformation[5]);
        information = strings[1];
        dividedInformation = information.split(" +");
        pack.setBytes(Integer.parseInt(dividedInformation[2]));
        return pack;

    }

    public PackageFromWireShark getLastPackage() {
        return lastPackage;
    }
}

