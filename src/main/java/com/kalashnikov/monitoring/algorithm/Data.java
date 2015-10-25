package com.kalashnikov.monitoring.algorithm;

public class  Data{
    private double[] data;
    public Data() {
        data = new double[0];
    }
    public void set(double... elements) {
        int size = elements.length;
        int i = 0;
        data = new double[size];
        for(double elem: elements) {
            data[i] = elem;
            i++;
        }
    }
    public double[] get() {
        double[] result = new double[data.length];
        result = data.clone();
        return result;
    }

    public int getSize() {
        return data.length;
    }

    public String print() {
        String result = "";
        for(int i = 0; i < data.length; i++) {
            result += data[i] + " ";
        }
        return result;
    }

    public void set(int index, double value) {
        if (index < 0) return;
        else if (index < data.length) {
            data[index] = value;
            return;
        }
        else  {
            double[] copy = new double[index+1];
            for(int i = 0; i < data.length; i++) {
                copy[i] = data[i];
            }
            for(int i = data.length; i < index; i++) {
                copy[i] = 0;
            }
            copy[index] = value;
            data = copy;

        }
    }



    public double get(int index) throws ArrayIndexOutOfBoundsException {
        try {
            return data[index];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }
    public double average(){
        double s=0;
        for(int i = 0; i < data.length; i++) {
            s = s+data[i];
        }
        return s/data.length;
    }
}

