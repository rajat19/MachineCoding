package com.paradox.cab.managers;

import com.paradox.cab.exceptions.RiderExistsException;
import com.paradox.cab.exceptions.RiderNotFoundException;
import com.paradox.cab.models.Rider;
import com.paradox.cab.services.RiderService;

public class RiderManager implements IManager{
    private final RiderService riderService;

    public RiderManager() {
        riderService = RiderService.getRiderServiceInstance();
    }

    @Override
    public void executeCommands(String[] commands) throws RiderExistsException, RiderNotFoundException {
        switch (commands[1]) {
            case "REGISTER":
                riderService.registerRider(commands[2], commands[3]);
                break;
            case "GET":
                Rider rider = riderService.getRider(commands[2]);
                System.out.println(rider);
                break;
        }
    }
}
