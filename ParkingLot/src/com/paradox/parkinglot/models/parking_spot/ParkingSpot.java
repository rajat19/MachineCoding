package com.paradox.parkinglot.models.parking_spot;

import com.paradox.parkinglot.models.enums.ParkingSpotType;
import com.paradox.parkinglot.models.vehicle.Vehicle;

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
