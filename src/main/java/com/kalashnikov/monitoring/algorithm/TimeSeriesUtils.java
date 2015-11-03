package com.kalashnikov.monitoring.algorithm;

public class TimeSeriesUtils {

    private double[] series;

    public TimeSeriesUtils() {
        series = new double[0];
    }

    public static void setTimeSeries(TimeSeriesUtils newSeries, double... elements) {
        int size = elements.length;
        int i = 0;
        newSeries.series = new double[size];
        for (double elem : elements) {
            newSeries.series[i] = elem;
            i++;
        }
    }

    public static double[] getTimeSeries(TimeSeriesUtils newSeries) {
        double[] result = new double[newSeries.series.length];
        result = newSeries.series.clone();
        return result;
    }

    public static int getSizeOfTimeSeries(TimeSeriesUtils newSeries) {
        return newSeries.series.length;
    }

    public static String printTimeSeries(TimeSeriesUtils newSeries) {
        String result = "";
        for (int i = 0; i < newSeries.series.length; i++) {
            result += newSeries.series[i] + " ";
        }
        return result;
    }

    public static void setTimeSeries(TimeSeriesUtils newSeries, int index, double value) {
        if (index < 0) return;
        else if (index < newSeries.series.length) {
            newSeries.series[index] = value;
            return;
        } else {
            double[] copy = new double[index + 1];
            for (int i = 0; i < newSeries.series.length; i++) {
                copy[i] = newSeries.series[i];
            }
            for (int i = newSeries.series.length; i < index; i++) {
                copy[i] = 0;
            }
            copy[index] = value;
            newSeries.series = copy;

        }
    }

    public static double getTimeSeries(TimeSeriesUtils newSeries, int index) throws ArrayIndexOutOfBoundsException {
        try {
            return newSeries.series[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public static double averageValueOfTimeSeries(TimeSeriesUtils newSeries) {
        double s = 0;
        for (int i = 0; i < newSeries.series.length; i++) {
            s = s + newSeries.series[i];
        }
        return s / newSeries.series.length;
    }
}