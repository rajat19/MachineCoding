package com.paradox.geeks.models;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, Cell> cellMap;
    private Player winner;

    public Board(int n) {
        cellMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            cellMap.put(i, new Cell(i));
        }
    }

    public Map<Integer, Cell> getCellMap() {
        return cellMap;
    }

    public void setCellMap(Map<Integer, Cell> cellMap) {
        this.cellMap = cellMap;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
