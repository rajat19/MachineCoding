package com.paradox.kafka.services;

import com.paradox.kafka.models.Producer;
import com.paradox.kafka.models.Topic;

import java.util.HashMap;
import java.util.Map;

public class ProducerService {
    private Map<String, Producer> producerMap;
    private static ProducerService producerService;

    private ProducerService() {
        this.producerMap = new HashMap<>();
    }

    public static ProducerService getInstance() {
        if (producerService == null) {
            synchronized (ProducerService.class) {
                if (producerService == null) {
                    producerService = new ProducerService();
                }
            }
        }
        return producerService;
    }

    public void addProducer(String producerId) {
        Producer producer = new Producer(producerId);
        producerMap.put(producerId, producer);
    }

    public void publish(String message, Topic topic) {
        topic.addMessage(message);
    }
}
