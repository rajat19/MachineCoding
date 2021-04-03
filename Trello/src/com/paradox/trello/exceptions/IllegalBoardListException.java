package com.paradox.trello.exceptions;

public class IllegalBoardListException extends Exception{
    public IllegalBoardListException(String listId) {
        super("List " + listId + " does not exist");
    }
}
