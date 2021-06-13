package com.paradox.kafka.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
    private String name;
    private List<String> messages;
    private Map<String, Consumer> subscribedConsumerMap;
    private int partitions;
    private int replicas;

    public Topic(String name, int partitions, int replicas) {
        this.name = name;
        this.partitions = partitions;
        this.replicas = replicas;
        this.messages = new ArrayList<>();
        this.subscribedConsumerMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
