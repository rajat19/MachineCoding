package com.paradox.cab.strategies;

import com.paradox.cab.models.Cab;
import com.paradox.cab.models.Location;
import com.paradox.cab.models.Rider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CabMatchingByDistanceStrategy implements CabMatchingStrategy{
    @Override
    public Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location from, Location to) {
        if (candidateCabs.isEmpty()) {
            return null;
        }
        candidateCabs.sort(Comparator.comparingDouble(c -> c.getCurrentLocation().distance(from)));
        return candidateCabs.get(0);
    }
}
