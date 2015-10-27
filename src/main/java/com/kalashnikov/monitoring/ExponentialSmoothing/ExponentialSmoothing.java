package com.kalashnikov.monitoring.ExponentialSmoothing;

public class ExponentialSmoothing {
    public TimeSeriesUtils createModel(double... elements) {
        TimeSeriesUtils newSeries = series();
        newSeries.setTimeSeries(elements);
        return newSeries;
    }

    public TimeSeriesUtils series() {
        TimeSeriesUtils newSeries = new TimeSeriesUtils();
        return newSeries;
    }

    public TimeSeriesUtils createExpSeries(TimeSeriesUtils packetSeries) {
        double alpha = 2.0 / (packetSeries.getSizeOfTimeSeries() + 1);
        TimeSeriesUtils expSeries = new TimeSeriesUtils();
        expSeries.setTimeSeries(0, packetSeries.averageValueOfTimeSeries());
        for (int i = 0; i < packetSeries.getSizeOfTimeSeries(); i++) {
            double result = alpha * packetSeries.getTimeSeries(i) + (1 - alpha) * expSeries.getTimeSeries(i);
            expSeries.setTimeSeries(i + 1, result);
        }
        return expSeries;

    }

    public void predictNextValue(TimeSeriesUtils packetSeries) {
        TimeSeriesUtils expSeries = createExpSeries(packetSeries);
        System.out.println(expSeries.getTimeSeries(expSeries.getSizeOfTimeSeries() - 1));
    }

    public void predictNextValues(TimeSeriesUtils packetSeries, int stepsNumber) {
        createExpSeries(packetSeries);
        for (int i = 0; i < stepsNumber; i++) {
            predictNextValue(createExpSeries(packetSeries));
        }
    }

    public static void main(String args[]) {
        ExponentialSmoothing mySeries = new ExponentialSmoothing();
        mySeries.predictNextValue(mySeries.createModel(2.99, 2.66, 2.63, 2.56, 2.40, 2.22, 1.97, 1.72, 1.56, 1.42));


    }
}
