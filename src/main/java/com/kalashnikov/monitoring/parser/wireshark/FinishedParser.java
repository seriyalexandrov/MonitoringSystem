package com.kalashnikov.monitoring.parser.wireshark;

import java.io.BufferedReader;
import java.util.ArrayList;


public class FinishedParser implements Runnable {
    public FinishedParser(BufferedReader br, ArrayList values, double timeInterval) {
        helper = new HelperToTheParser(timeInterval);
        this.values = values;
        this.br = br;
    }

    private ArrayList values;
    private BufferedReader br;
    private HelperToTheParser helper;

    @Override
    public void run() {
        setArrayList();
    }

    private synchronized void setArrayList() {
        ParserForWireSharkFiles parser;
        Thread thread;
        HelperToTheParser inputHelper;
        while (true) {
            parser = new ParserForWireSharkFiles(helper, br);
            thread = new Thread(parser);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inputHelper = parser.getHelper();
            if (inputHelper.getNumberOfPackages() == ParserForWireSharkFiles.END_OF_FILE_VALUE) {
                break;
            }
            values.add(inputHelper.getNumberOfPackages());
            inputHelper.setMaximumTime(inputHelper.getMaximumTime() + inputHelper.getTimeInterval());
            helper = inputHelper;
        }
    }
}
