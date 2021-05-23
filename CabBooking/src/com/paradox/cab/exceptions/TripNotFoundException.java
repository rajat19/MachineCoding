package com.paradox.cab.exceptions;

public class TripNotFoundException extends Exception{
    public TripNotFoundException(String cabId) {
        super("No trips exists for cab" + cabId);
    }
}
