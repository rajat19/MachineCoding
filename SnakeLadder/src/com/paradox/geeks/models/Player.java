package com.paradox.geeks.models;

public class Player {
    private String name;
    private Cell current;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCurrent() {
        return current;
    }

    public void setCurrent(Cell current) {
        this.current = current;
    }
}
