package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.algorithms.LinearTrend;
import com.kalashnikov.monitoring.algorithms.TimeSeriesManager;
import com.kalashnikov.monitoring.parser.wireshark.FinishedParser;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FactoryMethod extends Options{

    private static final Logger log = Logger.getLogger(FactoryMethod.class);

    public static final String LINEAR_TREND = "linear_trend";
    public static final String SINGLE_EXPONENTIAL_SMOOTHING = "single_exponential_smoothing";
    public static final String DOUBLE_EXPONENTIAL_SMOOTHING = "double_exponential_smoothing";
    public static final String LIMIT_IS_EXCEEDED_GET_READY_TO_IT = "Limit is exceeded! Get ready to it!";
    public static final String TIME_SERIES = "timeSeries = ";
    public static final String PREDICTED_VALUE = "predictedValue = ";
    public static final String FILE_WAS_NOT_FOUND = "File was not found";
    public static final String EXECUTION_WAS_STOPPED = "Execution was stopped";
    public static final String PROCESS_WAS_INTERRUPTED = "Process was interrupted";
    public static final String EXECUTION_TIME = "Execution time : ";
    public static final String SEC = "sec";
    public final String PATH = "src\\main\\resources\\traffic.cap";

    private final int SECOND = 1000;

    public void execute() {

        long startTime = System.currentTimeMillis();
        ArrayList<Integer> timeSeries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            FinishedParser parser = new FinishedParser(br, timeSeries, timeSeriesInterval);
            Thread thread = new Thread(parser);
            thread.start();

            switch (algorithmType) {
                case LINEAR_TREND:
                    for (int i = 0; i < predictionTime; i += predictionTimeInterval) {
                        Thread.sleep((long) (predictionTimeInterval * SECOND));
                        double predictedValue = linearTrend(timeSeries, timeSeriesInterval);
                        if (predictedValue > packetLimit) {
                            log.warn(LIMIT_IS_EXCEEDED_GET_READY_TO_IT);
                        }
                        System.out.println(TIME_SERIES + timeSeries);
                        System.out.println(PREDICTED_VALUE + predictedValue);
                    }
                    break;
            }

            thread.join();
        } catch (FileNotFoundException e) {
            log.error(FILE_WAS_NOT_FOUND, e);
        } catch (IOException e) {
            log.error(EXECUTION_WAS_STOPPED, e);
        } catch (InterruptedException e) {
            log.error(PROCESS_WAS_INTERRUPTED, e);
        }

        long endTime = System.currentTimeMillis() - startTime;
        log.info(EXECUTION_TIME + (double) endTime / SECOND + SEC);

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
        LinearTrend linearTrend = new LinearTrend();
        linearTrend.setTimeSeriesManager(manager);
        return linearTrend.predictNextValue();

    }

}
