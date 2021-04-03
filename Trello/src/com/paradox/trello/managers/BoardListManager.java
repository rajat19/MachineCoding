package com.paradox.trello.managers;

import com.paradox.trello.exceptions.IllegalBoardException;
import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.services.BoardListService;

public class BoardListManager implements IManager{
    private static BoardListManager boardListManager;
    private final BoardListService boardListService;

    private BoardListManager() {
        boardListService = BoardListService.getInstance();
    }

    public static synchronized BoardListManager getInstance() {
        if (boardListManager == null) {
            boardListManager = new BoardListManager();
        }
        return boardListManager;
    }

    @Override
    public void executeCommands(String[] commands) throws IllegalBoardException, IllegalBoardListException, IllegalCardException {
        if (commands[1].equals("CREATE")) {
            String boardId = commands[2];
            int commandsLen = commands.length;
            String listId = commands[3];
            StringBuilder listName = new StringBuilder();
            for(int i=4; i<commandsLen; i++) {
                listName.append(commands[i]).append(" ");
            }
            boardListService.createList(boardId, listId, listName.toString());
        } else if (commands[1].equals("DELETE")) {
            boardListService.deleteList(commands[2]);
        }
    }
}
