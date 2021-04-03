package com.paradox.trello.managers;

import com.paradox.trello.exceptions.*;
import com.paradox.trello.services.BoardService;

public class BoardManager implements IManager {
    private static BoardManager boardManager;
    private final BoardService boardService;

    private BoardManager() {
        boardService = BoardService.getInstance();
    }

    public static synchronized BoardManager getInstance() {
        if (boardManager == null) {
            boardManager = new BoardManager();
        }
        return boardManager;
    }

    @Override
    public void executeCommands(String[] commands) throws IllegalBoardException, UnknownUserException, IllegalBoardListException, IllegalCardException, IllegalBoardPrivacyException {
        if (commands[1].equals("CREATE")) {
            boardService.createBoard(commands[2], commands[3]);
        } else if (commands[1].equals("DELETE")) {
            boardService.deleteBoard(commands[2]);
        } else {
            String id = commands[1];
            if (commands[2].equals("ADD_MEMBER")) {
                boardService.addMember(id, commands[3]);
            } else if (commands[2].equals("REMOVE_MEMBER")) {
                boardService.removeMember(id, commands[3]);
            } else {
                boardService.updateBoard(id, commands[2], commands[3]);
            }
        }
    }
}
