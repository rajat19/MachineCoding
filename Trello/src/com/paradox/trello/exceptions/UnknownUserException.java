package com.paradox.trello.exceptions;

public class UnknownUserException extends Exception{
    public UnknownUserException(String message) {
        super(message);
    }
}
