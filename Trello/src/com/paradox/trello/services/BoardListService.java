package com.paradox.trello.services;

import com.paradox.trello.exceptions.IllegalBoardException;
import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.models.BoardList;
import com.paradox.trello.models.board.Board;

import java.util.HashMap;
import java.util.Map;

public class BoardListService {
    private final BoardService boardService;
    private static BoardListService boardListService;
    private final CardService cardService;
    private final Map<String, BoardList> boardListMap;

    private BoardListService() {
        boardService = BoardService.getBoardServiceInstance();
        cardService = CardService.getInstance();
        boardListMap = new HashMap<>();
    }

    public static synchronized BoardListService getInstance() {
        if (boardListService == null) {
            boardListService = new BoardListService();
        }
        return boardListService;
    }

    public Map<String, BoardList> getBoardListMap() {
        return boardListMap;
    }

    public void createList(String boardId, String listId, String listName) throws IllegalBoardException {
        if (!boardService.getBoardMap().containsKey(boardId)) {
            throw new IllegalBoardException(boardId);
        }
        Board board = boardService.getBoardMap().get(boardId);
        BoardList boardList = new BoardList(listId, listName, board);
        boardListMap.put(boardList.getId(), boardList);
        boardService.getBoardMap().get(boardId).addBoardList(boardList);
    }

    public void deleteLists(String boardId) throws IllegalBoardException, IllegalBoardListException, IllegalCardException {
        if (!boardService.getBoardMap().containsKey(boardId)) {
            throw new IllegalBoardException(boardId);
        }
        Map<String, BoardList> boardListMap = boardService.getBoardMap().get(boardId).getLists();
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
        cardService.deleteCards(boardList.getId());
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
