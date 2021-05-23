package com.paradox.cab.managers;

import com.paradox.cab.exceptions.*;

public class CommandManager implements IManager{
    private final CabManager cabManager;
    private final RiderManager riderManager;
    private final TripManager tripManager;

    public CommandManager() {
        cabManager = new CabManager();
        riderManager = new RiderManager();
        tripManager = new TripManager();
    }

    @Override
    public void executeCommands(String[] commands) throws CabNotFoundException, CabExistsException, RiderExistsException, RiderNotFoundException, TripNotFoundException, NoCabsAvailableException {
        switch (commands[0]) {
            case "CAB": cabManager.executeCommands(commands); break;
            case "RIDER": riderManager.executeCommands(commands); break;
            case "TRIP": tripManager.executeCommands(commands); break;
        }
    }
}
