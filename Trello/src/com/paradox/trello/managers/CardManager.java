package com.paradox.trello.managers;

import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.exceptions.UnknownUserException;
import com.paradox.trello.models.BoardList;
import com.paradox.trello.services.BoardListService;
import com.paradox.trello.services.CardService;
import com.paradox.trello.services.UserService;

public class CardManager implements IManager{
    private static CardManager cardManager;
    private final CardService cardService;
    private final UserService userService;
    private final BoardListService boardListService;

    private CardManager() {
        cardService = CardService.getInstance();
        userService = UserService.getInstance();
        boardListService = BoardListService.getInstance();
    }

    public static synchronized CardManager getInstance() {
        if (cardManager == null) {
            cardManager = new CardManager();
        }
        return cardManager;
    }

    @Override
    public void executeCommands(String[] commands) throws IllegalBoardListException, IllegalCardException, UnknownUserException {
        if (commands[1].equals("CREATE")) {
            String boardListId = commands[2];
            BoardList boardList = boardListService.getBoardList(boardListId);
            cardService.createCard(boardList, commands[3], commands[4]);
        } else if (commands[1].equals("DELETE")) {
            cardService.deleteCard(commands[2]);
        } else {
            String cardId = commands[1];
            if (commands[2].equals("ASSIGN")) {
                cardService.assignCard(cardId, userService.getUser(commands[3]));
            } else if (commands[2].equals("UNASSIGN")) {
                cardService.unAssignCard(cardId);
            } else if (commands[2].equals("MOVE")) {
                String newListId = commands[3];
                BoardList newBoardList = boardListService.getBoardList(newListId);
                cardService.moveCard(cardId, newBoardList);
            } else {
                cardService.updateCard(cardId, commands[2], commands[3]);
            }
        }
    }
}
