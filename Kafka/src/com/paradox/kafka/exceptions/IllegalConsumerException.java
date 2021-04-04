package com.paradox.kafka.exceptions;

public class IllegalConsumerException extends Exception{
    public IllegalConsumerException(String consumerId) {
        super("Consumer "+consumerId+" does not exists");
    }
}
