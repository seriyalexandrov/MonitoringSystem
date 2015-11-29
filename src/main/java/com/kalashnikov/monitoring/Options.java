package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;
import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;
import org.apache.log4j.Logger;

public class Options {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);
    private final double DOUBLE_ZERO = 0d;

    public String algorithmType = getAlgorithmType();
    public double timeSeriesInterval = getTimeSeriesInterval();
    public double predictionTimeInterval = getPredictionTimeInterval();
    public double predictionTime = getPredictionTime();
    public int packetLimit = getPacketLimit();
    public int numberOfValuesForTrend = getNumberOfValuesForTrend();

    String getAlgorithmType() {

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
        return DOUBLE_ZERO;

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

}