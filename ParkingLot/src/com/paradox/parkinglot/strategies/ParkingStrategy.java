package com.paradox.parkinglot.strategies;

import com.paradox.parkinglot.exceptions.NoFreeSlotAvailableException;

public interface ParkingStrategy {
    void addParkingSpot(Integer parkingSpotNumber);
    void removeParkingSpot(Integer parkingSpotNumber);
    Integer getNextParkingSpot() throws NoFreeSlotAvailableException;
}
