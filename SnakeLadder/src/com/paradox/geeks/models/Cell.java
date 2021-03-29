package com.paradox.geeks.models;

public class Cell {
    private int location;
    private Snake snake;
    private Ladder ladder;

    public Cell(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public boolean hasSnake() {
        return getSnake() != null;
    }

    public boolean hasLadder() {
        return getLadder() != null;
    }
}
