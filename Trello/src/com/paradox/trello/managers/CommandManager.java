package com.paradox.trello.managers;

import com.paradox.trello.exceptions.IllegalBoardException;
import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.exceptions.UnknownUserException;

public class CommandManager implements IManager{
    @Override
    public void executeCommands(String[] commands) throws IllegalBoardException, UnknownUserException, IllegalBoardListException, IllegalCardException {
        BoardManager boardManager = BoardManager.getInstance();
        BoardListManager boardListManager = BoardListManager.getInstance();
        CardManager cardManager = CardManager.getInstance();

        switch (commands[0]) {
            case "BOARD": boardManager.executeCommands(commands); break;
            case "LIST": boardListManager.executeCommands(commands); break;
            case "CARD": cardManager.executeCommands(commands); break;
        }
    }
}
