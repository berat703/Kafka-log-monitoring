package com.kafka.Models;

public class Log {

    private String timestamps;

    private String city;

    private String logLevel;

    private String details;


    public Log(String timestamps, String city, String logLevel, String details) {
        this.timestamps = timestamps;
        this.city = city;
        this.logLevel = logLevel;
        this.details = details;
    }

    public Log() {
    }

    public String getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(String timestamps) {
        this.timestamps = timestamps;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
