package com.paradox.parkingLot.models.parkingSpot;

import com.paradox.parkingLot.models.enums.ParkingSpotType;
import com.paradox.parkingLot.models.vehicle.Car;
import com.paradox.parkingLot.models.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean isFree() {
        return free;
    }

    public boolean isOccupied() {
        return !free;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        free = true;
    }
}
