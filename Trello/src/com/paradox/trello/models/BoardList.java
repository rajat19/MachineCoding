package com.paradox.trello.models;

import com.paradox.trello.models.board.Board;

import java.util.HashMap;
import java.util.Map;

public class BoardList {
    private String id;
    private String name;
    private Map<String, Card> cardMap;
    private Board board;

    public BoardList(String id, String name, Board board) {
        this.id = id;
        this.name = name;
        this.cardMap = new HashMap<>();
        this.board = board;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Card> getCards() {
        return cardMap;
    }

    public void setCards(Map<String, Card> cards) {
        this.cardMap = cards;
    }

    public void addCard(Card card) {
        this.cardMap.put(card.getId(), card);
    }

    public void deleteCard(Card card) {
        this.cardMap.remove(card.getId());
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "BoardList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cards=" + cardMap +
                '}';
    }
}
