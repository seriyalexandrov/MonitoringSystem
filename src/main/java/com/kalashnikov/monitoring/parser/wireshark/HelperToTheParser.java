package com.kalashnikov.monitoring.parser.wireshark;

public class HelperToTheParser {
    private String firstPackage;
    private int numberOfPackages;
    private double timeInterval;
    private double maximumTime;
    private final String FIRST_PACKAGE_INITIALIZATION = "firstPackage";


    public double getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(double maximumTime) {
        this.maximumTime = maximumTime;
    }

    @Override
    public String toString() {
        return "HelperToTheParser{" +
                "firstPackage='" + firstPackage + '\'' +
                ", numberOfPackages=" + numberOfPackages +
                ", timeInterval=" + timeInterval +
                ", maximumTime=" + maximumTime +
                '}';

    }

    public HelperToTheParser(double timeInterval){
        this.timeInterval = timeInterval;
        this.maximumTime = timeInterval;
        firstPackage = FIRST_PACKAGE_INITIALIZATION;
    }

    public int getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(int numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    public String getFirstPackage() {
        return firstPackage;
    }

    public void setFirstPackage(String firstPackage) {
        this.firstPackage = firstPackage;
    }

    public double getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(double timeInterval) {
        this.timeInterval = timeInterval;
    }
}
