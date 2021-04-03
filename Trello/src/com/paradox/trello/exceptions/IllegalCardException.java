package com.paradox.trello.exceptions;

public class IllegalCardException extends Exception{
    public IllegalCardException(String cardId) {
        super("Card " + cardId + " doesn't exist");
    }
}
