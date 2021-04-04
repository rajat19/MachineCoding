package com.paradox.kafka.exceptions;

public class IllegalProducerException extends Exception{
    public IllegalProducerException(String producerId) {
        super("Producer "+producerId+" does not exist");
    }
}
