package com.paradox.trello.managers;

import com.paradox.trello.exceptions.*;

public class CommandManager implements IManager{
    @Override
    public void executeCommands(String[] commands) throws IllegalBoardException, UnknownUserException, IllegalBoardListException, IllegalCardException, IllegalBoardPrivacyException {
        BoardManager boardManager = BoardManager.getInstance();
        BoardListManager boardListManager = BoardListManager.getInstance();
        CardManager cardManager = CardManager.getInstance();
        ShowManager showManager = ShowManager.getInstance();
        UserManager userManager = UserManager.getInstance();

        switch (commands[0]) {
            case "BOARD": boardManager.executeCommands(commands); break;
            case "LIST": boardListManager.executeCommands(commands); break;
            case "CARD": cardManager.executeCommands(commands); break;
            case "SHOW": showManager.executeCommands(commands); break;
            case "USER": userManager.executeCommands(commands); break;
        }
    }
}
