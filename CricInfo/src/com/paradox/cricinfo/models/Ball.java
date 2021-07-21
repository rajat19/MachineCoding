package com.paradox.cricinfo.models;

import com.paradox.cricinfo.models.actors.Player;
import com.paradox.cricinfo.models.enums.BallType;

import java.util.List;

public class Ball {
    private Player bowler;
    private Player batsman;
    private BallType type;
    private Wicket wicket;
    private List<Run> runs;
}
