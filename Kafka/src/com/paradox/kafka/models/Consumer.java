package com.paradox.kafka.models;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    private String id;
    private Map<String, Topic> subscribedTopicMap;

    public Consumer(String id) {
        this.id = id;
        this.subscribedTopicMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void subscribeTopic(Topic topic) {
        subscribedTopicMap.put(topic.getId(), topic);
    }

    public void unsubscribeTopic(Topic topic) {
        subscribedTopicMap.remove(topic.getId());
    }

    public void printMessage(String message) {
        System.out.println("Consumer " + this.getId() + " message: " + message);
    }
}
