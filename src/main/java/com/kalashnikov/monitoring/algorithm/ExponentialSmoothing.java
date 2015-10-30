package com.kalashnikov.monitoring.algorithm;

public class ExponentialSmoothing extends AbstractAlgorithm {

    public double createModel(TimeSeriesUtils packetSeries) {
        return 2.0 / (TimeSeriesUtils.getSizeOfTimeSeries(packetSeries) + 1);
    }

    public TimeSeriesUtils createSeries(double... elements) {
        TimeSeriesUtils newSeries = series();
        TimeSeriesUtils.setTimeSeries(newSeries, elements);
        return newSeries;
    }

    public TimeSeriesUtils series() {
        TimeSeriesUtils newSeries = new TimeSeriesUtils();
        return newSeries;
    }

    public TimeSeriesUtils createExpSeries(TimeSeriesUtils packetSeries) {
        double alpha = createModel(packetSeries);
        TimeSeriesUtils expSeries = series();
        TimeSeriesUtils.setTimeSeries(expSeries, 0, TimeSeriesUtils.averageValueOfTimeSeries(packetSeries));
        for (int i = 0; i < TimeSeriesUtils.getSizeOfTimeSeries(packetSeries); i++) {
            double result = alpha * TimeSeriesUtils.getTimeSeries(packetSeries, i) + (1 - alpha) * TimeSeriesUtils.getTimeSeries(expSeries, i);
            TimeSeriesUtils.setTimeSeries(expSeries, i + 1, result);
        }
        return expSeries;

    }

    public String printSeries(TimeSeriesUtils packetSeries) {
        return TimeSeriesUtils.printTimeSeries(packetSeries);
    }

    public double predictNextValue(TimeSeriesUtils packetSeries) {
        TimeSeriesUtils expSeries = createExpSeries(packetSeries);
        return TimeSeriesUtils.getTimeSeries(expSeries, TimeSeriesUtils.getSizeOfTimeSeries(expSeries) - 1);
    }

    /*public void  predictNextValues( TimeSeriesUtils packetSeries, int stepNumbers){
        TimeSeriesUtils helpSeries;
        for(int i = 0; i < stepNumbers; i++) {
            helpSeries = createExpSeries(packetSeries);
            packetSeries =  helpSeries;
            System.out.println(TimeSeriesUtils.getTimeSeries(packetSeries, TimeSeriesUtils.getSizeOfTimeSeries(packetSeries) - 1));
        }
    }
    */
}
