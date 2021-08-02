package com.paradox.parkinglot.strategies;

import com.paradox.parkinglot.exceptions.NoFreeSlotAvailableException;

import java.util.TreeSet;

public class NaturalOrderingParkingStrategy implements ParkingStrategy{
    private final TreeSet<Integer> parkingSpotSet;

    public NaturalOrderingParkingStrategy() {
        this.parkingSpotSet = new TreeSet<>();
    }

    @Override
    public void addParkingSpot(Integer parkingSpotNumber) {
        parkingSpotSet.add(parkingSpotNumber);
    }

    @Override
    public void removeParkingSpot(Integer parkingSpotNumber) {
        parkingSpotSet.remove(parkingSpotNumber);
    }

    @Override
    public Integer getNextParkingSpot() throws NoFreeSlotAvailableException {
        if (parkingSpotSet.isEmpty()) {
            throw new NoFreeSlotAvailableException();
        }
        return this.parkingSpotSet.first();
    }
}
