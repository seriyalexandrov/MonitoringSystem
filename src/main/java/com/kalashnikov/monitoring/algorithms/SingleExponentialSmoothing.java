package com.kalashnikov.monitoring.algorithms;

public class SingleExponentialSmoothing implements AbstractAlgorithm{

    private TimeSeriesManager timeSeriesManager;

    public void setTimeSeriesManager(TimeSeriesManager timeSeriesManager) {

        this.timeSeriesManager = timeSeriesManager;

    }

    @Override
    public double predictNextValue() {

        double adaptationCoefficient = 2.0 / (timeSeriesManager.getTimeSeries().size() + 1);

        double accumulator = timeSeriesManager.getTimeSeries().get(0);

        for (int numberOfValue = 0; numberOfValue < timeSeriesManager.getTimeSeries().size(); numberOfValue++) {
            accumulator = timeSeriesManager.getTimeSeries().get(numberOfValue) * adaptationCoefficient  +
                    accumulator * (1 - adaptationCoefficient);
        }

        return accumulator;

    }

}