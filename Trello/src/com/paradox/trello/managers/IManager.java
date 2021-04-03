package com.paradox.trello.managers;

import com.paradox.trello.exceptions.*;

public interface IManager {
    void executeCommands(String[] commands) throws IllegalBoardException, UnknownUserException, IllegalBoardListException, IllegalCardException, IllegalBoardPrivacyException;
}
