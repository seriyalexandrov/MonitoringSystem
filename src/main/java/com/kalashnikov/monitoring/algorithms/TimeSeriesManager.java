package com.kalashnikov.monitoring.algorithms;

import java.util.ArrayList;

public  class TimeSeriesManager {

    private ArrayList<Integer> timeSeries;
    private double period;

    public  TimeSeriesManager() {

        timeSeries = new ArrayList<>();

    }

    public ArrayList<Integer> getTimeSeries() {

        return timeSeries;

    }

    public void setTimeSeries(ArrayList<Integer> timeSeries) {

        this.timeSeries = timeSeries;

    }

    public double getPeriod() {

        return period;

    }

    public void setPeriod(double period) {

        this.period = period;

    }

    public void add(int numberOfPackets) {

        timeSeries.add(numberOfPackets);

    }

}