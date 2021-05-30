package com.paradox.parkingLot.exceptions;

public class ParkingLotAlreadyExistsException extends Exception{
    public ParkingLotAlreadyExistsException() {
        super("Parking lot already exists");
    }
}
