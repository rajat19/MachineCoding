package com.paradox.parkingLot.models;

import com.paradox.parkingLot.exceptions.ParkingLotSizeException;
import com.paradox.parkingLot.models.parkingSpot.ParkingSpot;
import com.paradox.parkingLot.models.vehicle.Vehicle;

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

    private ParkingSpot getParkingSpot(Integer parkingSpotNumber) {
        if (parkingSpotNumber > getCapacity() || parkingSpotNumber <= 0) {

        }
        return getParkingSpots().get(parkingSpotNumber);
    }

    public ParkingSpot park(Vehicle vehicle, int slotNumber) {
        ParkingSpot parkingSpot = getParkingSpot(slotNumber);
        if (!parkingSpot.isFree()) {

        }
        parkingSpot.assignVehicle(vehicle);
        return parkingSpot;
    }

    public ParkingSpot makeSpotFree(Integer slotNumber) {
        ParkingSpot parkingSpot = getParkingSpot(slotNumber);
        parkingSpot.removeVehicle();
        return parkingSpot;
    }
}
