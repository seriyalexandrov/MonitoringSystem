package com.kalashnikov.monitoring.parser.wireshark;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.util.ArrayList;


public class FinishedParser implements Runnable {


    private static final Logger log = Logger.getLogger(FinishedParser.class);
    private ArrayList values;
    private BufferedReader br;
    private double timeInterval;


    public FinishedParser(BufferedReader br, ArrayList values, double timeInterval) {
        this.timeInterval = timeInterval;
        this.values = values;
        this.br = br;
    }


    @Override
    public void run() {
        setValues();
    }


    private synchronized void setValues() {
        int numberOfPackages;
        double maxTime;
        String lastPackage;
        ParserForWireSharkFiles parser;
        maxTime = timeInterval;
        parser = new ParserForWireSharkFiles(ParserForWireSharkFiles.FIRST_PACKAGE_INITIALIZATION, maxTime, br);
        while (true) {
            try {
                Thread.sleep((long) (timeInterval * 1000));
            } catch (InterruptedException e) {
                log.error(e);
            }
            numberOfPackages = parser.getNumberOfPackages();
            if (numberOfPackages == ParserForWireSharkFiles.END_OF_FILE_VALUE) {
                break;
            }
            values.add(numberOfPackages);
            maxTime += timeInterval;
            lastPackage = parser.getLastPackage();
            parser = new ParserForWireSharkFiles(lastPackage, maxTime, br);
        }
    }
}
