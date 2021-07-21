package com.paradox.cricinfo.models.actors;

import com.paradox.cricinfo.models.PlayerContract;
import com.paradox.cricinfo.models.Team;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Person person;
    private final List<PlayerContract> contracts = new ArrayList<>();
    private Team team;

    public void addContract(PlayerContract contract) {
        contracts.add(contract);
    }
}
