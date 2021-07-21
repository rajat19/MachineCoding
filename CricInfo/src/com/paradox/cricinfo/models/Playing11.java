package com.paradox.cricinfo.models;

import com.paradox.cricinfo.models.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class Playing11 {
    private List<Player> players;
    private Player twelfthMan;

    public Playing11() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
