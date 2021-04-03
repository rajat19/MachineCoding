package com.paradox.trello.exceptions;

public class IllegalBoardException extends Exception{
    public IllegalBoardException(String boardId) {
        super("Board" + boardId + " does not exist");
    }
}
