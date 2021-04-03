package com.paradox.trello.managers;

import com.paradox.trello.exceptions.IllegalBoardException;
import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.exceptions.UnknownUserException;

public interface IManager {
    void executeCommands(String[] commands) throws IllegalBoardException, UnknownUserException, IllegalBoardListException, IllegalCardException;
}
