package com.paradox.kafka.services;

import com.paradox.kafka.exceptions.IllegalConsumerException;
import com.paradox.kafka.models.Consumer;
import com.paradox.kafka.models.Topic;

import java.util.HashMap;
import java.util.Map;

public class ConsumerService {
    private Map<String, Consumer> consumerMap;
    private static ConsumerService consumerService;

    private ConsumerService() {
        this.consumerMap = new HashMap<>();
    }

    public static ConsumerService getInstance() {
        if (consumerService == null) {
            synchronized (ConsumerService.class) {
                if (consumerService == null) {
                    consumerService = new ConsumerService();
                }
            }
        }
        return consumerService;
    }

    public void addConsumer(String consumerId) {
        Consumer consumer = new Consumer(consumerId);
        consumerMap.put(consumerId, consumer);
    }

    public void subscribe(String consumerId, Topic topic) throws IllegalConsumerException {
        if (!consumerMap.containsKey(consumerId)) {
            throw new IllegalConsumerException(consumerId);
        }
        Consumer consumer = consumerMap.get(consumerId);
        topic.addConsumer(consumer);
        consumer.subscribeTopic(topic);
    }

    public void unsubscribe(String consumerId, Topic topic) throws IllegalConsumerException {
        if (!consumerMap.containsKey(consumerId)) {
            throw new IllegalConsumerException(consumerId);
        }
        Consumer consumer = consumerMap.get(consumerId);
        topic.removeConsumer(consumer);
        consumer.unsubscribeTopic(topic);
    }
}
