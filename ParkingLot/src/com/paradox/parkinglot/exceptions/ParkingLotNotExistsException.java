package com.paradox.parkinglot.exceptions;

public class ParkingLotNotExistsException extends Exception{
    public ParkingLotNotExistsException() {
        super("Parking lot not exists");
    }
}
