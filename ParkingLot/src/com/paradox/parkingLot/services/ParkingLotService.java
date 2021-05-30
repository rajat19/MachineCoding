package com.paradox.parkingLot.services;

import com.paradox.parkingLot.exceptions.NoFreeSlotAvailableException;
import com.paradox.parkingLot.exceptions.ParkingLotAlreadyExistsException;
import com.paradox.parkingLot.exceptions.ParkingLotNotExistsException;
import com.paradox.parkingLot.models.ParkingLot;
import com.paradox.parkingLot.models.parkingSpot.ParkingSpot;
import com.paradox.parkingLot.models.vehicle.Vehicle;
import com.paradox.parkingLot.strategies.ParkingStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;
    private static ParkingLotService instance;

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) throws ParkingLotAlreadyExistsException {
        if (this.parkingLot != null) {
            throw new ParkingLotAlreadyExistsException();
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i=1; i<= parkingLot.getCapacity(); i++) {
            parkingStrategy.addParkingSpot(i);
        }
    }

    public Integer park(Vehicle vehicle) throws NoFreeSlotAvailableException, ParkingLotNotExistsException {
        if (parkingLot == null) {
            throw new ParkingLotNotExistsException();
        }
        Integer nextFreeSlot = parkingStrategy.getNextParkingSpot();
        parkingLot.park(vehicle, nextFreeSlot);
        parkingStrategy.removeParkingSpot(nextFreeSlot);
        return nextFreeSlot;
    }

    public void makeSlotFree(Integer slotNumber) throws ParkingLotNotExistsException {
        if (parkingLot == null) {
            throw new ParkingLotNotExistsException();
        }
        parkingLot.makeSpotFree(slotNumber);
        parkingStrategy.addParkingSpot(slotNumber);
    }

    public List<ParkingSpot> getOccupiedSlots() throws ParkingLotNotExistsException {
        if (parkingLot == null) {
            throw new ParkingLotNotExistsException();
        }
        final Map<Integer, ParkingSpot> allSpots = parkingLot.getParkingSpots();
        return allSpots.values().stream()
                .filter(ParkingSpot::isOccupied)
                .collect(Collectors.toList());
    }
}
