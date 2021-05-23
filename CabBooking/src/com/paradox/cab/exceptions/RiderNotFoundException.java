package com.paradox.cab.exceptions;

public class RiderNotFoundException extends Exception{
    public RiderNotFoundException(String riderId) { super("Rider with id: "+ riderId +" not found");}
}
