package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.algorithm.linear.trend.LinearTrend;
import com.kalashnikov.monitoring.algorithm.linear.trend.TimeSeriesManager;
import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;
import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;
import com.kalashnikov.monitoring.parser.wireshark.FinishedParser;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemExecutor {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);
    public final String PATH = "src\\main\\resources\\traffic.cap";

    private String algorithmType = getAlgorithmType();
    private double timeSeriesInterval = getTimeSeriesInterval();
    private double predictionTimeInterval = getPredictionTimeInterval();
    private double predictionTime = getPredictionTime();
    private int packetLimit = getPacketLimit();
    private int numberOfValuesForTrend = getNumberOfValuesForTrend();

    public void execute() {

        long startTime = System.currentTimeMillis();
        ArrayList<Integer> timeSeries = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            FinishedParser parser = new FinishedParser(br, timeSeries, timeSeriesInterval);
            Thread thread = new Thread(parser);
            thread.start();

            switch (algorithmType) {
                case "linear_trend":
                    for (int i = 0; i < predictionTime; i += predictionTimeInterval) {
                        Thread.sleep((long) (predictionTimeInterval*1000));
                        double predictedValue = linearTrend(timeSeries, timeSeriesInterval);
                        if (predictedValue > packetLimit) {
                            log.warn("Limit is exceeded! Get ready to it!");
                        }
                        System.out.println("timeSeries = "+ timeSeries);
                        System.out.println("predictedValue = " + predictedValue);
                    }
                    break;
            }
            thread.join();
        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.fatal(e);
        } catch (InterruptedException e) {
            log.error(e);
        }

        long endTime = System.currentTimeMillis() - startTime;
        log.info("Execution time : " + (double) endTime / 1000 + "sec");

    }

    private double linearTrend(ArrayList<Integer> timeSeries, double timeInterval) {

        TimeSeriesManager manager = new TimeSeriesManager();
        ArrayList<Integer> partOfTimeSeries;
        if (timeSeries.size() == 0) {
            partOfTimeSeries = new ArrayList<>();
        } else if (timeSeries.size() < numberOfValuesForTrend) {
            partOfTimeSeries = new ArrayList<>(timeSeries.subList(0, timeSeries.size()-1));
        } else {
            partOfTimeSeries = new ArrayList<>(timeSeries.
                    subList(timeSeries.size()-numberOfValuesForTrend, timeSeries.size()-1));
        }
        manager.setTimeSeries(partOfTimeSeries);
        manager.setPeriod(timeInterval);
        LinearTrend linearTrend = new LinearTrend(manager);
        return linearTrend.predictNextValue();

    }

    private String getAlgorithmType() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return configurationManager.getOptionValue("algorithm");
        } catch (NoSuchOptionException e) {
            log.error("No such options", e);
        }
        return null;

    }

    private double getTimeSeriesInterval() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Double.parseDouble(configurationManager.getOptionValue("time_series_interval"));
        } catch (NoSuchOptionException e) {
            log.error("No such options", e);
        }
        return 0d;

    }

    private double getPredictionTimeInterval() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Double.parseDouble(configurationManager.getOptionValue("prediction_time_interval"));
        } catch (NoSuchOptionException e) {
            log.error("No such options", e);
        }
        return 0d;

    }

    private double getPredictionTime() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Double.parseDouble(configurationManager.getOptionValue("prediction_time"));
        } catch (NoSuchOptionException e) {
            log.error("No such options", e);
        }
        return 0d;

    }

    private int getPacketLimit() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Integer.parseInt(configurationManager.getOptionValue("packet_limit"));
        } catch (NoSuchOptionException e) {
            log.error("No such options", e);
        }
        return 0;

    }

    private int getNumberOfValuesForTrend() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Integer.parseInt(configurationManager.getOptionValue("number_of_values_for_trend"));
        } catch (NoSuchOptionException e) {
            log.error("No such options", e);
        }
        return 0;

    }

    public static void main(String[] args) {

        SystemExecutor systemExecutor = new SystemExecutor();
        systemExecutor.execute();
    }

}