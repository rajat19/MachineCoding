package com.paradox.cab.services;

import com.paradox.cab.exceptions.RiderExistsException;
import com.paradox.cab.exceptions.RiderNotFoundException;
import com.paradox.cab.models.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderService {
    private final Map<String, Rider> riderMap;
    private static RiderService riderServiceInstance;

    private RiderService() {
        riderMap = new HashMap<>();
    }

    public static RiderService getRiderServiceInstance() {
        if (riderServiceInstance == null) {
            synchronized (RiderService.class) {
                if (riderServiceInstance == null) {
                    riderServiceInstance = new RiderService();
                }
            }
        }
        return riderServiceInstance;
    }

    public void registerRider(String riderId, String name) throws RiderExistsException {
        if (riderMap.containsKey(riderId)) {
            throw new RiderExistsException(riderId);
        }
        Rider rider = new Rider(riderId, name);
        riderMap.put(riderId, rider);
    }

    public Rider getRider(String riderId) throws RiderNotFoundException {
        if (!riderMap.containsKey(riderId)) {
            throw new RiderNotFoundException(riderId);
        }
        return riderMap.get(riderId);
    }
}
