package com.kalashnikov.monitoring.algorithms;

public class LinearTrend implements AbstractAlgorithm {

    private TimeSeriesManager timeSeriesManager;

    private double averageValue;
    private double averageTime;

    private double valueStandardDeviation;
    private double timeStandardDeviation;

    private double correlationCoefficient;

    private double regressionCoefficient;

    private double shift;

    public void setTimeSeriesManager(TimeSeriesManager timeSeriesManager) {

        this.timeSeriesManager = timeSeriesManager;

    }

    private void calculateAverageValue() {

        double sumOfValues = 0;
        for (int numberOfValue = 0; numberOfValue < timeSeriesManager.getTimeSeries().size(); numberOfValue++) {
            sumOfValues += timeSeriesManager.getTimeSeries().get(numberOfValue);
        }
        averageValue = sumOfValues / timeSeriesManager.getTimeSeries().size();

        averageTime = timeSeriesManager.getPeriod() * (timeSeriesManager.getTimeSeries().size() - 1) / 2;

    }

    private void calculateStandardDeviation() {

        double sumOfSquaredValuesDeviations = 0;
        double sumOfSquaredTimesDeviations = 0;
        double time = 0;
        for (int numberOfValue = 0; numberOfValue < timeSeriesManager.getTimeSeries().size(); numberOfValue++) {
            sumOfSquaredValuesDeviations +=
                    Math.pow((timeSeriesManager.getTimeSeries().get(numberOfValue) - averageValue), 2);
            sumOfSquaredTimesDeviations += Math.pow((time - averageTime), 2);
            time += timeSeriesManager.getPeriod();
        }
        valueStandardDeviation = Math.sqrt(sumOfSquaredValuesDeviations / timeSeriesManager.getTimeSeries().size());
        timeStandardDeviation = Math.sqrt(sumOfSquaredTimesDeviations / timeSeriesManager.getTimeSeries().size());

    }

    private void calculateCorrelationCoefficient() {

        double sumOfMultiplyOfDeviations = 0;
        double time = 0;
        for (int numberOfValue = 0; numberOfValue < timeSeriesManager.getTimeSeries().size(); numberOfValue++) {
            sumOfMultiplyOfDeviations += (timeSeriesManager.getTimeSeries().get(numberOfValue) - averageValue) *
                    (time - averageTime);
            time += timeSeriesManager.getPeriod();
        }

        if (valueStandardDeviation == 0) {
            correlationCoefficient = 0;
        } else {
            correlationCoefficient = sumOfMultiplyOfDeviations / (timeSeriesManager.getTimeSeries().size() *
                    valueStandardDeviation * timeStandardDeviation);
        }

    }

    private void calculateRegressionCoefficient() {

        regressionCoefficient = correlationCoefficient * (valueStandardDeviation / timeStandardDeviation);

    }

    private void calculateShift() {

        shift = averageValue - averageTime * regressionCoefficient;

    }

    @Override
    public double predictNextValue() {

        calculateAverageValue();
        calculateStandardDeviation();
        calculateCorrelationCoefficient();
        calculateRegressionCoefficient();
        calculateShift();

        return regressionCoefficient * (timeSeriesManager.getTimeSeries().size() * timeSeriesManager.getPeriod()) +
                shift;

    }

}