package com.paradox.parkingLot.exceptions;

public class NoFreeSlotAvailableException extends Exception{
    public NoFreeSlotAvailableException() {
        super("No free slots available");
    }
}
