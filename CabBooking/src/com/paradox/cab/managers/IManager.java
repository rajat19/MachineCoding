package com.paradox.cab.managers;

import com.paradox.cab.exceptions.*;

public interface IManager {
    void executeCommands(String[] commands) throws CabExistsException, CabNotFoundException, RiderExistsException, RiderNotFoundException, NoCabsAvailableException, TripNotFoundException;
}
