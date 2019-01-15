package com.hgsoft.springcloud.servicestreamtest.entity;

public class Greetings {
    private long timestamp;
    private String message;

    public Greetings(long timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Greetings() {

    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
