package com.paradox.cab.services;

import com.paradox.cab.exceptions.CabExistsException;
import com.paradox.cab.exceptions.CabNotFoundException;
import com.paradox.cab.models.Cab;
import com.paradox.cab.models.Location;

import java.util.*;

public class CabService {
    private final Map<String, Cab> cabMap;
    private static CabService cabServiceInstance;

    private CabService() {
        this.cabMap = new HashMap<>();
    }

    public static CabService getCabsServiceInstance() {
        if (cabServiceInstance == null) {
            synchronized (CabService.class) {
                if (cabServiceInstance == null) {
                    cabServiceInstance = new CabService();
                }
            }
        }
        return cabServiceInstance;
    }

    public Cab getCab(String cabId) throws CabNotFoundException {
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException(cabId);
        }
        return cabMap.get(cabId);
    }

    public void registerCab(String cabId, String driverName) throws CabExistsException {
        if (cabMap.containsKey(cabId)) {
            throw new CabExistsException(cabId);
        }
        Cab cab = new Cab(cabId, driverName);
        cabMap.put(cabId, cab);
    }

    public void updateCabAvailability(String cabId, boolean newAvailability) throws CabNotFoundException {
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException(cabId);
        }
        cabMap.get(cabId).setAvailable(newAvailability);
    }

    public void updateCabLocation(String cabId, double x, double y) throws CabNotFoundException {
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException(cabId);
        }
        Location location = new Location(x, y);
        cabMap.get(cabId).setCurrentLocation(location);
    }

    public List<Cab> getCabs(Location from, double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab: cabMap.values()) {
            if (cab.isAvailable() && cab.getCurrentLocation().distance(from) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }
}
