package com.kalashnikov.monitoring.algorithm;

public class Algorithm {
    public static void main(String args[]) {
        Data myData = new Data();
        Data expData = new Data();
        myData.set(2.99, 2.66, 2.63, 2.56, 2.40, 2.22, 1.97, 1.72, 1.56, 1.42);
        double alpha = 2.0/(myData.getSize() + 1);
        expData.set(0, myData.average());
        for (int i = 0; i < myData.getSize(); i++) {
            double result = alpha*myData.get(i) + (1 - alpha)*expData.get(i);
            expData.set(i + 1,result );
        }
        System.out.print(expData.print());
    }
}