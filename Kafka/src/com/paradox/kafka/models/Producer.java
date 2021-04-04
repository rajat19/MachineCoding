package com.paradox.kafka.models;

import java.util.HashMap;
import java.util.Map;

public class Producer {
    private String id;

    public Producer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
