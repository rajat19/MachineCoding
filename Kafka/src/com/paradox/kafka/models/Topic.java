package com.paradox.kafka.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
    private String id;
    private List<String> messages;
    private Map<String, Consumer> subscribedConsumerMap;

    public Topic(String id) {
        this.id = id;
        this.messages = new ArrayList<>();
        this.subscribedConsumerMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addMessage(String message) {
        messages.add(message);
        notifyConsumers();
    }

    public void addConsumer(Consumer consumer) {
        subscribedConsumerMap.put(consumer.getId(), consumer);
    }

    public void removeConsumer(Consumer consumer) {
        subscribedConsumerMap.remove(consumer.getId());
    }

    private void notifyConsumers() {
        for(String id: subscribedConsumerMap.keySet()) {
            Consumer consumer = subscribedConsumerMap.get(id);
            consumer.printMessage(this.messages.get(this.messages.size() - 1));
        }
    }
}
