package com.paradox.kafka.services;

import com.paradox.kafka.exceptions.IllegalTopicException;
import com.paradox.kafka.models.Topic;

import java.util.HashMap;
import java.util.Map;

public class QueueService {
    private static QueueService queueService;
    private Map<String, Topic> topicMap;

    private QueueService() {
        this.topicMap = new HashMap<>();
    }

    public static QueueService getInstance() {
        if (queueService == null) {
            synchronized (QueueService.class) {
                if (queueService == null) {
                    queueService = new QueueService();
                }
            }
        }
        return queueService;
    }

    public void createTopic(String name, int partitions, int replicas) {
        Topic topic = new Topic(name, partitions, replicas);
        this.topicMap.put(name, topic);
    }

    public Topic getTopic(String name) throws IllegalTopicException {
        if (!topicMap.containsKey(name)) {
            throw new IllegalTopicException(name);
        }
        return this.topicMap.get(name);
    }
}
