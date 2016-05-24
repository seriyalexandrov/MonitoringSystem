package com.kalashnikov.monitoring.algorithms.factory;

import com.kalashnikov.monitoring.SystemExecutor;
import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;
import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;
import org.apache.log4j.Logger;

public class Options {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);
    public static final String ALGORITHM = "algorithm";
    public static final String NO_SUCH_OPTIONS = "No such options";
    public static final String TIME_SERIES_INTERVAL = "time_series_interval";
    public static final String PREDICTION_TIME_INTERVAL = "prediction_time_interval";
    public static final String PREDICTION_TIME = "prediction_time";
    public static final String NUMBER_OF_VALUES_FOR_TREND = "number_of_values_for_trend";
    public static final String PACKET_LIMIT = "packet_limit";
    public static final String NUMBER_OF_INTERVALS = "number_of_intervals";
    private final double DOUBLE_ZERO = 0d;

    public String algorithmType = getAlgorithmType();
    public double timeSeriesInterval = getTimeSeriesInterval();
    public double predictionTimeInterval = getPredictionTimeInterval();
    public double predictionTime = getPredictionTime();
    public int numberOfIntervals = getNumberOfIntervals();
    public int packetLimit = getPacketLimit();
    public int numberOfValuesForTrend = getNumberOfValuesForTrend();

    String getAlgorithmType() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return configurationManager.getOptionValue(ALGORITHM);
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + ALGORITHM, e);
        }
        return null;

    }

    private double getTimeSeriesInterval() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Double.parseDouble(configurationManager.getOptionValue(TIME_SERIES_INTERVAL));
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + TIME_SERIES_INTERVAL, e);
        }
        return DOUBLE_ZERO;

    }

    private double getPredictionTimeInterval() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Double.parseDouble(configurationManager.getOptionValue(PREDICTION_TIME_INTERVAL));
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + PREDICTION_TIME_INTERVAL, e);
        }
        return DOUBLE_ZERO;

    }

    private double getPredictionTime() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Double.parseDouble(configurationManager.getOptionValue(PREDICTION_TIME));
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + PREDICTION_TIME, e);
        }
        return DOUBLE_ZERO;

    }

    private int getPacketLimit() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Integer.parseInt(configurationManager.getOptionValue(PACKET_LIMIT));
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + PACKET_LIMIT, e);
        }
        return 0;

    }

    private int getNumberOfValuesForTrend() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Integer.parseInt(configurationManager.getOptionValue(NUMBER_OF_VALUES_FOR_TREND));
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + NUMBER_OF_VALUES_FOR_TREND, e);
        }
        return 0;

    }
    private int getNumberOfIntervals() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        try {
            return Integer.parseInt(configurationManager.getOptionValue(NUMBER_OF_INTERVALS));
        } catch (NoSuchOptionException e) {
            log.error(NO_SUCH_OPTIONS + ": " + NUMBER_OF_INTERVALS, e);
        }
        return 0;

    }

}