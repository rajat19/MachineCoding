package com.paradox.cab.managers;

import com.paradox.cab.exceptions.CabExistsException;
import com.paradox.cab.exceptions.CabNotFoundException;
import com.paradox.cab.models.Cab;
import com.paradox.cab.services.CabService;

public class CabManager implements IManager{
    private final CabService cabService;

    public CabManager() {
        this.cabService = CabService.getCabsServiceInstance();
    }

    @Override
    public void executeCommands(String[] commands) throws CabExistsException, CabNotFoundException {
        switch (commands[1]) {
            case "REGISTER":
                cabService.registerCab(commands[2], commands[3]);
                break;
            case "GET":
                Cab cab = cabService.getCab(commands[2]);
                System.out.println(cab);
                break;
            case "AVAILABLE":
                cabService.updateCabAvailability(commands[2], Boolean.parseBoolean(commands[3]));
                break;
            case "LOCATION":
                cabService.updateCabLocation(commands[2], Double.parseDouble(commands[3]), Double.parseDouble(commands[4]));
                break;
        }
    }
}
