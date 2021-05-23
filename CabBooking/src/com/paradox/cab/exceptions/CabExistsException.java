package com.paradox.cab.exceptions;

public class CabExistsException extends Exception{
    public CabExistsException(String cabId) {
        super("Cab with id: "+ cabId + " already exists");
    }
}
