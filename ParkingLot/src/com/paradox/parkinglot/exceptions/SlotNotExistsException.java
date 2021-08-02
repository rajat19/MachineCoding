package com.paradox.parkinglot.exceptions;

public class SlotNotExistsException extends Exception{
    public SlotNotExistsException(int parkingSpot) {
        super("Parking spot not exists:: "+parkingSpot);
    }
}
