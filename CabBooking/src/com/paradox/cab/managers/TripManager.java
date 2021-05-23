package com.paradox.cab.managers;

import com.paradox.cab.exceptions.*;
import com.paradox.cab.models.Location;
import com.paradox.cab.models.Trip;
import com.paradox.cab.services.TripService;

import java.util.List;

public class TripManager implements IManager{
    private final TripService tripService;

    public TripManager() {
        tripService = TripService.getTripServiceInstance();
    }

    @Override
    public void executeCommands(String[] commands) throws RiderNotFoundException, NoCabsAvailableException, TripNotFoundException, CabNotFoundException {
        switch (commands[1]) {
            case "CREATE":
                Location from = new Location(Double.parseDouble(commands[3]), Double.parseDouble(commands[4]));
                Location to = new Location(Double.parseDouble(commands[5]), Double.parseDouble(commands[6]));
                tripService.createTrip(commands[2], from, to);
                break;
            case "HISTORY":
                List<Trip> trips = tripService.tripHistory(commands[2]);
                System.out.println(trips);
                break;
            case "END":
                tripService.endTrip(commands[2]);
                break;
        }
    }
}
