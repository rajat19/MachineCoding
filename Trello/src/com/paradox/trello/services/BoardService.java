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
    private final Map<String, User> userMap;
    private static BoardService boardServiceInstance;
    private final BoardListService boardListService;

    private BoardService() {
        this.boardMap = new HashMap<>();
        UserService userService = UserService.getInstance();
        this.userMap = userService.getUserMap();
        this.boardListService = BoardListService.getInstance();
    }

    public static BoardService getBoardServiceInstance() {
        if (boardServiceInstance == null) {
            synchronized(BoardService.class) {
                if (boardServiceInstance == null) {
                    boardServiceInstance = new BoardService();
                }
            }
        }
        return boardServiceInstance;
    }

    public Map<String, Board> getBoardMap() {
        return boardMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void createBoard(String id, String name) {
        Board board = new PublicBoard(id, name);
        boardMap.put(board.getId(), board);
    }

    public void deleteBoard(String id) throws IllegalBoardException, IllegalBoardListException, IllegalCardException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        boardMap.remove(id);
        boardListService.deleteLists(id);
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
        switch (key) {
            case "name": boardMap.get(id).setName(value); break;
            case "url": boardMap.get(id).setUrl(value); break;
            case "privacy": boardMap.get(id).setPrivacy(BoardPrivacy.getBoardPrivacy(value)); break;
        }
    }

    public void addMember(String id, String memberId) throws IllegalBoardException, UnknownUserException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        if (!userMap.containsKey(memberId)) {
            throw new UnknownUserException("No such user exists");
        }
        boardMap.get(id).addMember(userMap.get(memberId));
    }

    public void removeMember(String id, String memberId) throws IllegalBoardException, UnknownUserException {
        if (!boardMap.containsKey(id)) {
            throw new IllegalBoardException(id);
        }
        if (!userMap.containsKey(memberId)) {
            throw new UnknownUserException("No such user exists");
        }
        boardMap.get(id).removeMember(userMap.get(memberId));
    }
}
