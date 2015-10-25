package com.kalashnikov.monitoring.parser.wireshark;


public class PackageFromWireShark {
    public PackageFromWireShark(int id) {
        this.id = id;
    }

    private int id;
    private double time;
    private String source;
    private String destination;
    private String protocol;

    public int getId() {
        return id;
    }

    public double getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String toString() {
        return "No.: " + id + "; Time = " + time + "; Source: " + source + "; Destination: " + destination + "; Protocol: " + protocol;
    }
}
