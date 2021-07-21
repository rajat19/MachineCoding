package com.paradox.cricinfo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tournament {
    private String id;
    private List<Team> teams;
    private Date startDate;
    private Date endDate;

    public Tournament(String id, Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teams = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
