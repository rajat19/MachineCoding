package com.paradox.kafka.exceptions;

public class IllegalTopicException extends Exception{
    public IllegalTopicException(String topicName) {
        super("Topic " + topicName + " doesnt exists");
    }
}
