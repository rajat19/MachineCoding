package com.paradox.kafka.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Producer {
    private final String id;
    private final List<Topic> topics;

    public Producer(String id) {
        this.id = id;
        this.topics = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public void publish(String message) {
        for(Topic topic: topics) {
            topic.addMessage(message);
        }
    }
}
