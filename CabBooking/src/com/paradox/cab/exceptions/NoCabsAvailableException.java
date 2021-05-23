package com.paradox.cab.exceptions;

public class NoCabsAvailableException extends Exception{
    public NoCabsAvailableException() {
        super("No cabs are available right now!!");
    }
}
