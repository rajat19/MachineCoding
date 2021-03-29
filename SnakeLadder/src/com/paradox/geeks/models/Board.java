package com.paradox.geeks.models;

import java.util.*;

public class Board {
    private Map<Integer, Cell> cellMap;
    private Player winner;
    private Set<Player> playersStillPlaying;
    private List<Player> winners;
    private int maxWinners;

    public Board(int n) {
        cellMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            cellMap.put(i, new Cell(i));
        }
        playersStillPlaying = new HashSet<>();
        winners = new ArrayList<>();
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

    public Set<Player> getPlayersStillPlaying() {
        return playersStillPlaying;
    }

    public void setPlayersStillPlaying(Set<Player> playersStillPlaying) {
        this.playersStillPlaying = playersStillPlaying;
    }

    public List<Player> getWinners() {
        return winners;
    }

    public void setWinners(List<Player> winners) {
        this.winners = winners;
    }

    public int getMaxWinners() {
        return maxWinners;
    }

    public void setMaxWinners(int maxWinners) {
        this.maxWinners = maxWinners;
    }
}
