package com.paradox.trello.services;

import com.paradox.trello.exceptions.IllegalCardException;
import com.paradox.trello.models.BoardList;
import com.paradox.trello.models.Card;
import com.paradox.trello.models.User;

import java.util.HashMap;
import java.util.Map;

public class CardService {
    private static CardService cardService;
    private final Map<String, Card> cardMap;

    private CardService() {
        this.cardMap = new HashMap<>();
    }

    public static synchronized CardService getInstance() {
        if (cardService == null) {
            cardService = new CardService();
        }
        return cardService;
    }

    public void createCard(BoardList boardList, String cardId, String cardName) {
        Card card = new Card(cardId, cardName, "", boardList);
        boardList.addCard(card);
        this.cardMap.put(cardId, card);
        System.out.println("Created Card:: "+cardId);
    }

    public void deleteCards(BoardList boardList) throws IllegalCardException {
        Map<String, Card> cardMap = boardList.getCards();
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

    public void moveCard(String cardId, BoardList newBoardList) throws IllegalCardException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        Card card = cardMap.get(cardId);
        BoardList originalList = card.getBoardList();
        originalList.deleteCard(card);
        newBoardList.addCard(card);
        card.setBoardList(newBoardList);
    }

    public void updateCard(String id, String key, String value) throws IllegalCardException {
        if (!cardMap.containsKey(id)) {
            throw new IllegalCardException(id);
        }
        Card card = cardMap.get(id);
        switch (key) {
            case "name": card.setName(value); break;
            case "description": card.setDescription(value); break;
        }
    }

    public void showCard(String cardId) throws IllegalCardException {
        if (!cardMap.containsKey(cardId)) {
            throw new IllegalCardException(cardId);
        }
        System.out.println(cardMap.get(cardId));
    }
}
