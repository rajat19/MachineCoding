package com.paradox.cab.exceptions;

public class RiderExistsException extends Exception{
    public RiderExistsException(String riderId) {
        super("Rider with id: "+ riderId + " already exists");
    }
}
