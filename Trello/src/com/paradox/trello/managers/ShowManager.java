package com.paradox.trello.managers;

import com.paradox.trello.exceptions.IllegalBoardException;
import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.services.BoardListService;
import com.paradox.trello.services.BoardService;
import com.paradox.trello.services.CardService;

public class ShowManager implements IManager{
    private final BoardService boardService;
    private final BoardListService boardListService;
    private final CardService cardService;
    private static ShowManager showManager;

    private ShowManager() {
        boardService = BoardService.getInstance();
        boardListService = BoardListService.getInstance();
        cardService = CardService.getInstance();
    }

    public static synchronized ShowManager getInstance() {
        if (showManager == null) {
            showManager = new ShowManager();
        }
        return showManager;
    }

    @Override
    public void executeCommands(String[] commands) throws IllegalBoardException, IllegalBoardListException, IllegalCardException {
        if (commands.length == 1) {
            boardService.showBoards();
        } else {
            String type = commands[1];
            String id = commands[2];
            switch (type) {
                case "BOARD": boardService.showBoard(id); break;
                case "LIST": boardListService.showList(id); break;
                case "CARD": cardService.showCard(id); break;
            }
        }
    }
}
