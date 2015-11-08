package com.kalashnikov.monitoring.parser.wireshark;

import java.io.BufferedReader;
import java.util.ArrayList;


public class FinishedParser implements Runnable {
    public FinishedParser(BufferedReader br, ArrayList values, double timeInterval) {
        this.timeInterval = timeInterval;
        this.values = values;
        this.br = br;
    }

    private ArrayList values;
    private BufferedReader br;
    private double timeInterval;

    @Override
    public void run() {
        setArrayList();
    }

    private synchronized void setArrayList() {
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
                e.printStackTrace();
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
