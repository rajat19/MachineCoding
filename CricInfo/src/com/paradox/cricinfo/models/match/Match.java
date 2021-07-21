package com.paradox.cricinfo.models.match;

import com.paradox.cricinfo.models.Inning;
import com.paradox.cricinfo.models.Playing11;
import com.paradox.cricinfo.models.actors.Umpire;
import com.paradox.cricinfo.models.enums.MatchStatus;

import java.util.Date;
import java.util.List;

public abstract class Match {
    private int number;
    private Date startTime;
    private MatchStatus matchStatus;
    private Playing11[] teams;
    private List<Inning> innings;
    private List<Umpire> umpires;
}
