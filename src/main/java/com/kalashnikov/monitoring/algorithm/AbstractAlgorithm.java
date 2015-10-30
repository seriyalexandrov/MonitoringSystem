package com.kalashnikov.monitoring.algorithm;

public abstract class AbstractAlgorithm {
    public abstract double createModel(TimeSeriesUtils packetSeries);

    public abstract double predictNextValue(TimeSeriesUtils packetSeries);

}
