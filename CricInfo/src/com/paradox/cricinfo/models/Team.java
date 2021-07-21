package com.paradox.cricinfo.models;

import com.paradox.cricinfo.models.actors.Coach;
import com.paradox.cricinfo.models.actors.Player;

import java.util.List;
import java.util.Map;

public class Team {
    private String name;
    private List<Player> players;
    private Coach coach;
    private Map<String, TournamentSquad> tournamentSquadMap;

    public void addTournamentSquad(Tournament tournament, TournamentSquad squad) {
        tournamentSquadMap.put(tournament.getId(), squad);
    }
}
