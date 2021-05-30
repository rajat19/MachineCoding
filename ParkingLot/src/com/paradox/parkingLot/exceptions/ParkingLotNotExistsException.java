package com.paradox.parkingLot.exceptions;

public class ParkingLotNotExistsException extends Exception{
    public ParkingLotNotExistsException() {
        super("Parking lot not exists");
    }
}
