package com.paradox.trello.services;

import com.paradox.trello.exceptions.IllegalBoardListException;
import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.models.BoardList;
import com.paradox.trello.models.Card;
import com.paradox.trello.models.User;

import java.util.HashMap;
import java.util.Map;

public class CardService {
    private static CardService cardService;
    private final BoardListService boardListService;
    private final Map<String, Card> cardMap;

    private CardService() {
        this.cardMap = new HashMap<>();
        this.boardListService = BoardListService.getInstance();
    }

    public static synchronized CardService getInstance() {
        if (cardService == null) {
            cardService = new CardService();
        }
        return cardService;
    }

    public void createCard(String listId, String cardId, String cardName) throws IllegalBoardListException {
        if (!boardListService.getBoardListMap().containsKey(listId)) {
            throw new IllegalBoardListException(listId);
        }
        BoardList boardList = boardListService.getBoardListMap().get(listId);
        Card card = new Card(cardId, cardName, "", boardList);
        boardList.addCard(card);
        this.cardMap.put(cardId, card);
    }

    public void deleteCards(String boardListId) throws IllegalCardException, IllegalBoardListException {
        if (!boardListService.getBoardListMap().containsKey(boardListId)) {
            throw new IllegalBoardListException(boardListId);
        }
        Map<String, Card> cardMap = boardListService.getBoardListMap().get(boardListId).getCards();
        for (String listId: cardMap.keySet()) {
            deleteCard(listId);
        }
    }

    public void deleteCard(String cardId) throws IllegalCardException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        Card card = cardMap.get(cardId);
        BoardList boardList = card.getBoardList();
        cardMap.remove(cardId);
        boardList.deleteCard(card);
    }

    public void assignCard(String cardId, User user) throws IllegalCardException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        Card card = cardMap.get(cardId);
        card.setAssignedUser(user);
    }

    public void unAssignCard(String cardId) throws IllegalCardException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        Card card = cardMap.get(cardId);
        card.setAssignedUser(null);
    }

    public void moveCard(String cardId, String newListId) throws IllegalCardException, IllegalBoardListException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        if (!boardListService.getBoardListMap().containsKey(newListId)) {
            throw new IllegalBoardListException(newListId);
        }
        Card card = cardMap.get(cardId);
        BoardList originalList = card.getBoardList();
        originalList.deleteCard(card);
        BoardList newList = boardListService.getBoardListMap().get(newListId);
        newList.addCard(card);
        card.setBoardList(newList);
    }

    public void showCard(String cardId) throws IllegalCardException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        System.out.println(cardMap.get(cardId));
    }
}
