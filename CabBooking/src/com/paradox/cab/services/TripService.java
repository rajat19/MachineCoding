package com.paradox.cab.services;

import com.paradox.cab.exceptions.CabNotFoundException;
import com.paradox.cab.exceptions.NoCabsAvailableException;
import com.paradox.cab.exceptions.RiderNotFoundException;
import com.paradox.cab.exceptions.TripNotFoundException;
import com.paradox.cab.models.Cab;
import com.paradox.cab.models.Location;
import com.paradox.cab.models.Rider;
import com.paradox.cab.models.Trip;
import com.paradox.cab.strategies.CabMatchingByDistanceStrategy;
import com.paradox.cab.strategies.CabMatchingStrategy;
import com.paradox.cab.strategies.DefaultPricingStrategy;
import com.paradox.cab.strategies.PricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripService {
    private final Map<String, List<Trip>> trips;
    private final CabService cabService;
    private final RiderService riderService;
    private final CabMatchingStrategy cabMatchingStrategy;
    private final PricingStrategy pricingStrategy;

    private static TripService tripServiceInstance;
    private static final double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;

    private TripService() {
        trips = new HashMap<>();
        cabService = CabService.getCabsServiceInstance();
        riderService = RiderService.getRiderServiceInstance();
        cabMatchingStrategy = new CabMatchingByDistanceStrategy();
        pricingStrategy = new DefaultPricingStrategy();
    }

    public static TripService getTripServiceInstance() {
        if (tripServiceInstance == null) {
            synchronized (TripService.class) {
                if (tripServiceInstance == null) {
                    tripServiceInstance = new TripService();
                }
            }
        }
        return tripServiceInstance;
    }

    public void createTrip(String riderId, Location from, Location to) throws NoCabsAvailableException, RiderNotFoundException {
        Rider rider = riderService.getRider(riderId);
        final List<Cab> closeByCabs = cabService.getCabs(from, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
        final List<Cab> availableCabs = closeByCabs.stream()
                .filter(cab -> cab.getCurrentTrip() == null)
                .collect(Collectors.toList());
        final Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, availableCabs, from, to);
        if (selectedCab == null) {
            throw new NoCabsAvailableException();
        }
        final double price = pricingStrategy.findPrice(from, to);
        final Trip newTrip = new Trip(rider, selectedCab, price, from, to);
        if (!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
    }

    public List<Trip> tripHistory(String riderId) throws RiderNotFoundException {
        Rider rider = riderService.getRider(riderId);
        return trips.get(rider.getId());
    }

    public void endTrip(String cabId) throws TripNotFoundException, CabNotFoundException {
        Cab cab = cabService.getCab(cabId);
        if (cab.getCurrentTrip() == null) {
            throw new TripNotFoundException(cab.getId());
        }
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
