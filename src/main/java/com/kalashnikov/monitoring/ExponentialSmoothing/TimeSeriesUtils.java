package com.kalashnikov.monitoring.ExponentialSmoothing;


public class TimeSeriesUtils {
    private double[] series;

    public TimeSeriesUtils() {
        series = new double[0];
    }

    public void setTimeSeries(double... elements) {
        int size = elements.length;
        int i = 0;
        series = new double[size];
        for (double elem : elements) {
            series[i] = elem;
            i++;
        }
    }

    public double[] getTimeSeries() {
        double[] result = new double[series.length];
        result = series.clone();
        return result;
    }

    public int getSizeOfTimeSeries() {
        return series.length;
    }

    public String printTimeSeries() {
        String result = "";
        for (int i = 0; i < series.length; i++) {
            result += series[i] + " ";
        }
        return result;
    }

    public void setTimeSeries(int index, double value) {
        if (index < 0) return;
        else if (index < series.length) {
            series[index] = value;
            return;
        } else {
            double[] copy = new double[index + 1];
            for (int i = 0; i < series.length; i++) {
                copy[i] = series[i];
            }
            for (int i = series.length; i < index; i++) {
                copy[i] = 0;
            }
            copy[index] = value;
            series = copy;

        }
    }

    public double getTimeSeries(int index) throws ArrayIndexOutOfBoundsException {
        try {
            return series[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public double averageValueOfTimeSeries() {
        double s = 0;
        for (int i = 0; i < series.length; i++) {
            s = s + series[i];
        }
        return s / series.length;
    }
}


