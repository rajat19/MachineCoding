package com.paradox.trello.services;

import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.models.BoardList;
import com.paradox.trello.models.board.Board;

import java.util.HashMap;
import java.util.Map;

public class BoardListService {
    private static BoardListService boardListService;
    private final CardService cardService;
    private final Map<String, BoardList> boardListMap;

    private BoardListService() {
        cardService = CardService.getInstance();
        boardListMap = new HashMap<>();
    }

    public static synchronized BoardListService getInstance() {
        if (boardListService == null) {
            boardListService = new BoardListService();
        }
        return boardListService;
    }

    public BoardList getBoardList(String boardListId) throws IllegalBoardListException {
        if (!boardListMap.containsKey(boardListId)) {
            throw new IllegalBoardListException(boardListId);
        }
        return boardListMap.get(boardListId);
    }

    public void createList(Board board, String listId, String listName) {
        BoardList boardList = new BoardList(listId, listName, board);
        boardListMap.put(boardList.getId(), boardList);
        board.addBoardList(boardList);
        System.out.println("Created List:: "+listId);
    }

    public void deleteLists(Board board) throws IllegalBoardListException, IllegalCardException {
        Map<String, BoardList> boardListMap = board.getLists();
        for (String listId: boardListMap.keySet()) {
            deleteList(listId);
        }
    }

    public void deleteList(String listId) throws IllegalBoardListException, IllegalCardException {
        if (!boardListMap.containsKey(listId)) {
            throw new IllegalBoardListException(listId);
        }
        BoardList boardList = boardListMap.get(listId);
        Board board = boardList.getBoard();
        cardService.deleteCards(boardList);
        boardListMap.remove(listId);
        board.deleteBoardList(boardList);
    }

    public void showList(String listId) throws IllegalBoardListException {
        if (!boardListMap.containsKey(listId)) {
            throw new IllegalBoardListException(listId);
        }
        System.out.println(boardListMap.get(listId));
    }
}
