package com.paradox.kafka.models;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    private final String id;
    private Topic topic;

    public Consumer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void subscribeTopic(Topic topic) {
        this.topic = topic;
    }

    public void unsubscribeTopic() {
        this.topic = null;
    }

    public void printMessage(String message) {
        System.out.println("Consumer " + this.getId() + " message: " + message);
    }
}
