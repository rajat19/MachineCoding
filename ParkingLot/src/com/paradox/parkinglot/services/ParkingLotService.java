package com.paradox.parkinglot.services;

import com.paradox.parkinglot.exceptions.*;
import com.paradox.parkinglot.models.ParkingLot;
import com.paradox.parkinglot.models.parking_spot.ParkingSpot;
import com.paradox.parkinglot.models.vehicle.Vehicle;
import com.paradox.parkinglot.strategies.ParkingStrategy;

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

    public Integer park(Vehicle vehicle) throws NoFreeSlotAvailableException, ParkingLotNotExistsException, SlotNotExistsException, SlotNotFreeException {
        if (parkingLot == null) {
            throw new ParkingLotNotExistsException();
        }
        Integer nextFreeSlot = parkingStrategy.getNextParkingSpot();
        parkingLot.park(vehicle, nextFreeSlot);
        parkingStrategy.removeParkingSpot(nextFreeSlot);
        return nextFreeSlot;
    }

    public void makeSlotFree(Integer slotNumber) throws ParkingLotNotExistsException, SlotNotExistsException {
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
