package com.paradox.parkinglot.exceptions;

public class ParkingLotSizeException extends Exception{
    public ParkingLotSizeException(int capacity) {
        super("Invalid capacity" + capacity + " for parking lot.");
    }
}
