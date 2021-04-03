package com.paradox.trello.services;

import com.paradox.trello.exceptions.*;
import com.paradox.trello.models.User;
import com.paradox.trello.models.board.Board;
import com.paradox.trello.models.board.PublicBoard;
import com.paradox.trello.models.enums.BoardPrivacy;

import java.util.HashMap;
import java.util.Map;

public class BoardService {
    private final Map<String, Board> boardMap;
    private static BoardService boardServiceInstance;
    private final BoardListService boardListService;
    private final UserService userService;

    private BoardService() {
        this.boardMap = new HashMap<>();
        this.userService = UserService.getInstance();
        this.boardListService = BoardListService.getInstance();
    }

    public static BoardService getInstance() {
        if (boardServiceInstance == null) {
            synchronized(BoardService.class) {
                if (boardServiceInstance == null) {
                    boardServiceInstance = new BoardService();
                }
            }
        }
        return boardServiceInstance;
    }

    public Board getBoard(String id) throws IllegalBoardException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        return boardMap.get(id);
    }

    public void createBoard(String id, String name) {
        Board board = new PublicBoard(id, name);
        boardMap.put(board.getId(), board);
        System.out.println("Created Board:: "+id);
    }

    public void deleteBoard(String id) throws IllegalBoardException, IllegalBoardListException, IllegalCardException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        Board board = boardMap.get(id);
        boardListService.deleteLists(board);
        boardMap.remove(id);
    }

    public void showBoard(String id) throws IllegalBoardException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        System.out.println(boardMap.get(id));
    }

    public void showBoards() {
        if (boardMap.keySet().size() == 0) {
            System.out.println("No Boards");
        } else {
            System.out.println(boardMap);
        }
    }

    public void updateBoard(String id, String key, String value) throws IllegalBoardException, IllegalBoardPrivacyException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        Board board = boardMap.get(id);
        switch (key) {
            case "name": board.setName(value); break;
            case "url": board.setUrl(value); break;
            case "privacy": board.setPrivacy(BoardPrivacy.getBoardPrivacy(value)); break;
        }
    }

    public void addMember(String id, String memberId) throws IllegalBoardException, UnknownUserException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        User user = userService.getUser(memberId);
        boardMap.get(id).addMember(user);
    }

    public void removeMember(String id, String memberId) throws IllegalBoardException, UnknownUserException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        User user = userService.getUser(memberId);
        boardMap.get(id).removeMember(user);
    }
}
