package com.kalashnikov.monitoring.algorithms;

public interface AbstractAlgorithm {

    double predictNextValue();
    void setTimeSeriesManager(TimeSeriesManager timeSeriesManager);

}