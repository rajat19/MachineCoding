package com.paradox.parkingLot.strategies;

import com.paradox.parkingLot.exceptions.NoFreeSlotAvailableException;

public interface ParkingStrategy {
    void addParkingSpot(Integer parkingSpotNumber);
    void removeParkingSpot(Integer parkingSpotNumber);
    Integer getNextParkingSpot() throws NoFreeSlotAvailableException;
}
