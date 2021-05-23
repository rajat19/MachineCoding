package com.paradox.cab.exceptions;

public class CabNotFoundException extends Exception{
    public CabNotFoundException(String cabId) { super("Cab with id: "+ cabId+" not found");}
}
