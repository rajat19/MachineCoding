package com.paradox.parkinglot.exceptions;

public class SlotNotFreeException extends Exception{
    public SlotNotFreeException(int parkingSpot) {
        super("Parking spot not free:: "+parkingSpot);
    }
}
