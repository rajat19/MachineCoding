package com.paradox.kafka.services;

import com.paradox.kafka.exceptions.IllegalProducerException;
import com.paradox.kafka.exceptions.IllegalTopicException;
import com.paradox.kafka.models.Producer;
import com.paradox.kafka.models.Topic;

import java.util.HashMap;
import java.util.Map;

public class ProducerService {
    private Map<String, Producer> producerMap;
    private static ProducerService producerService;
    private final QueueService queueService;

    private ProducerService() {
        this.producerMap = new HashMap<>();
        this.queueService = QueueService.getInstance();
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

    public void publish(String producerId, String message) throws IllegalProducerException {
        if (!producerMap.containsKey(producerId)) {
            throw new IllegalProducerException(producerId);
        }
        Producer producer = producerMap.get(producerId);
        producer.publish(message);
    }

    public void addTopicToProducer(String producerId, String topicName) throws IllegalProducerException, IllegalTopicException {
        if (!producerMap.containsKey(producerId)) {
            throw new IllegalProducerException(producerId);
        }
        Topic topic = queueService.getTopic(topicName);
        Producer producer = producerMap.get(producerId);
        producer.addTopic(topic);
    }
}
