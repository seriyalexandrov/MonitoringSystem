package com.kalashnikov.monitoring.parser.wireshark;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.util.ArrayList;


public class Parser implements Runnable {


    private static final Logger log = Logger.getLogger(Parser.class);
    private ArrayList values;
    private BufferedReader br;
    private double timeInterval;
    private int numberOfIntervals;
    private final int MILLISECONDS_IN_SECOND = 1000;


    public Parser(BufferedReader br, ArrayList values, double timeInterval, int numberOfIntervals) {
        this.timeInterval = timeInterval;
        this.values = values;
        this.br = br;
        this.numberOfIntervals = numberOfIntervals;
    }


    @Override
    public void run() {
        setValues();
    }


    private synchronized void setValues() {

        ArrayList<PackageFromWireShark> arrayListOfPackages;
        double maxTime = timeInterval;
        PackageFromWireShark lastPackage;
        ParserForWireSharkFiles parser = new ParserForWireSharkFiles(null, maxTime, br, timeInterval);
        for (int i = 0; i < numberOfIntervals; i++) {
            if (Thread.interrupted()) {
                break;
            }
            arrayListOfPackages = parser.getArrayListOfPackages();
            values.add(arrayListOfPackages);
            maxTime += timeInterval;
            lastPackage = parser.getLastPackage();
            parser = new ParserForWireSharkFiles(lastPackage, maxTime, br, timeInterval);
        }
    }

}
