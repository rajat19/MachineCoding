package com.paradox.trello.exceptions;

public class UnknownUserException extends Exception{
    public UnknownUserException(String userId) {
        super("User: " + userId + " doesn't exists");
    }
}
