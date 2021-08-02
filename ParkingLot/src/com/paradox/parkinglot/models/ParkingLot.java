package com.paradox.parkinglot.models;

import com.paradox.parkinglot.exceptions.ParkingLotSizeException;
import com.paradox.parkinglot.exceptions.SlotNotExistsException;
import com.paradox.parkinglot.exceptions.SlotNotFreeException;
import com.paradox.parkinglot.models.parking_spot.ParkingSpot;
import com.paradox.parkinglot.models.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Integer, ParkingSpot> parkingSpots;
    private static final int MAX_CAPACITY = 100000;

    public ParkingLot(int capacity) throws ParkingLotSizeException {
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new ParkingLotSizeException(capacity);
        }
        this.capacity = capacity;
        this.parkingSpots = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<Integer, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    private ParkingSpot getParkingSpot(Integer parkingSpotNumber) throws SlotNotExistsException {
        if (parkingSpotNumber > getCapacity() || parkingSpotNumber <= 0) {
            throw new SlotNotExistsException(parkingSpotNumber);
        }
        return getParkingSpots().get(parkingSpotNumber);
    }

    public void park(Vehicle vehicle, int slotNumber) throws SlotNotExistsException, SlotNotFreeException {
        ParkingSpot parkingSpot = getParkingSpot(slotNumber);
        if (!parkingSpot.isFree()) {
            throw new SlotNotFreeException(slotNumber);
        }
        parkingSpot.assignVehicle(vehicle);
    }

    public void makeSpotFree(Integer slotNumber) throws SlotNotExistsException {
        ParkingSpot parkingSpot = getParkingSpot(slotNumber);
        parkingSpot.removeVehicle();
    }
}
