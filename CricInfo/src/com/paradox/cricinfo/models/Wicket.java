package com.paradox.cricinfo.models;

import com.paradox.cricinfo.models.actors.Player;
import com.paradox.cricinfo.models.enums.WicketType;

public class Wicket {
    private WicketType wicketType;
    private Player playerOut;
    private Player caughtBy;
    private Player runoutBy;
    private Player stumpedBy;
}
