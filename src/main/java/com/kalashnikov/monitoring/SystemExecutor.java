package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.algorithm.linear.trend.LinearTrend;
import com.kalashnikov.monitoring.algorithm.linear.trend.TimeSeriesManager;
import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;
import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;
import com.kalashnikov.monitoring.parser.wireshark.PackageFromWireShark;
//import com.kalashnikov.monitoring.parser.wireshark.ParserForWireSharkFiles;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SystemExecutor {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);
    private static final int NUMBER_OF_OPTIONS = 3;


    public void execute() {

        long startTime = System.currentTimeMillis();

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        Map<String, String> options = new TreeMap<String, String>();

        try {
            for (int i = 0; i < NUMBER_OF_OPTIONS; ++i) {
                options.put("Option" + (i+1), configurationManager.getOptionValue("Option" + (i+1)));
            }
        } catch (NoSuchOptionException e) {
            ;
        }

//        ParserForWireSharkFiles parser = new ParserForWireSharkFiles();
//        List<PackageFromWireShark> packages = parser.getPackageListFromFile();

        switch(options.get("Option1")) {
            case "LinearTrend":
                //linearTrend(packages, options);
                break;
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Execution time : " + (double)endTime/1000 + "sec");
    }


    private void linearTrend(List<PackageFromWireShark> packages, Map<String, String> options) {

        //we somehow process our packages so as to fill TimeSeriesManager
        ArrayList<Integer> timeSeries = new ArrayList<Integer>();
        TimeSeriesManager manager = new TimeSeriesManager();
        manager.setTimeSeries(timeSeries);
        manager.setPeriod(Double.parseDouble(options.get("Option2")));
        LinearTrend linearTrend = new LinearTrend(manager);
        System.out.println(linearTrend.predictNextValue());
    }


    public static void main(String[] args) {

        SystemExecutor systemExecutor = new SystemExecutor();
        systemExecutor.execute();

    }

}