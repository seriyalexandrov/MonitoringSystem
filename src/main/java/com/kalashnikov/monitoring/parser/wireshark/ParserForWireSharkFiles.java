package com.kalashnikov.monitoring.parser.wireshark;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserForWireSharkFiles {


    private static final Logger log = Logger.getLogger(ParserForWireSharkFiles.class);
    private BufferedReader bufferedReader;
    private final String REGEX = "^No\\. +Time +Source +Destination +Protocol +$";
    private static final int NUMBER_OF_USEFUL_STRINGS = 2;
    private static final String READING_ERROR = "Reading error";
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
        long currentTime = System.currentTimeMillis();


        while ((currentTime - startTime) < timeInterval * MILLISECONDS_IN_SECOND) {

            if (firstPackage == null) {
                firstPackage = getFirstPackage();
            }

            if (firstPackage != null) {
                if (!checkFirstPackage(firstPackage, maxTime)) {
                    lastPackage = firstPackage;
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
                            return packages;
                        }
                    }

                    if (line.matches(REGEX)) {
                        stringLikeRegexpFlag = true;
                    }
                }
                currentTime = System.currentTimeMillis();

            } catch (IOException e) {
                log.error(READING_ERROR, e);
                return null;
            }
        }
        lastPackage = null;
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
            return null;
        } catch (IOException e) {
            log.error(READING_ERROR, e);
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

