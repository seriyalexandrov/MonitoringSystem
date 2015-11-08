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
        HelperToTheParser inputHelper;
        while (true) {
            parser = new ParserForWireSharkFiles(helper, br);
            try {
                Thread.sleep((long) (helper.getTimeInterval()*1000));
                System.out.println("privet");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parser.setHelperWithNumberOfPackages();
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
