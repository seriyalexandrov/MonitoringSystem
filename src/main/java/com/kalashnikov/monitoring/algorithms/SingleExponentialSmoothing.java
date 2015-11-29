package com.kalashnikov.monitoring.algorithms;

public class SingleExponentialSmoothing implements AbstractAlgorithm{

    private double adaptationCoefficient;

    private double accumulator;

    public SingleExponentialSmoothing(TimeSeriesManager timeSeriesManager) {

        adaptationCoefficient = 2.0 / (timeSeriesManager.getTimeSeries().size() + 1);

        accumulator = timeSeriesManager.getTimeSeries().get(0);

        for (int numberOfValue = 0; numberOfValue < timeSeriesManager.getTimeSeries().size(); numberOfValue++) {
            accumulator = timeSeriesManager.getTimeSeries().get(numberOfValue) * adaptationCoefficient  +
                    accumulator * (1 - adaptationCoefficient);
        }

    }

    @Override
    public double predictNextValue() {

        return accumulator;

    }

}