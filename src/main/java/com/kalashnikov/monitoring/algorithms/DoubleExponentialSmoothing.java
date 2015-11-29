package com.kalashnikov.monitoring.algorithms;

public class DoubleExponentialSmoothing implements AbstractAlgorithm {

    private double levelSmoothingFactor;
    private double trendSmoothingFactor;

    private double level;
    private double trend;

    public DoubleExponentialSmoothing(TimeSeriesManager timeSeriesManager) {

        levelSmoothingFactor = 2.0 / (timeSeriesManager.getTimeSeries().size() + 1);
        trendSmoothingFactor = 2.0 / (timeSeriesManager.getTimeSeries().size() + 1);

        level = timeSeriesManager.getTimeSeries().get(0);
        trend = (timeSeriesManager.getTimeSeries().get(timeSeriesManager.getTimeSeries().size() - 1) -
                timeSeriesManager.getTimeSeries().get(0)) / (timeSeriesManager.getTimeSeries().size() - 1.0);

        double tempLevel;
        double tempTrend;
        for (int numberOfValue = 1; numberOfValue < timeSeriesManager.getTimeSeries().size(); numberOfValue++) {
            tempLevel = level;
            tempTrend = trend;
            level = levelSmoothingFactor * timeSeriesManager.getTimeSeries().get(numberOfValue) +
                    (1 - levelSmoothingFactor) * (tempLevel + tempTrend);
            trend = trendSmoothingFactor * (level - tempLevel) + (1 - trendSmoothingFactor) * tempTrend;
        }

    }

    @Override
    public double predictNextValue() {

        return level + trend;

    }

}