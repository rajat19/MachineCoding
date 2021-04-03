package com.paradox.trello.models;

public class Card {
    private String id;
    private String name;
    private String description;
    private User assignedUser;
    private BoardList boardList;

    public Card(String id, String name, String description, BoardList boardList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.boardList = boardList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public BoardList getBoardList() {
        return boardList;
    }

    public void setBoardList(BoardList boardList) {
        this.boardList = boardList;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedUser=" + assignedUser +
                '}';
    }
}
