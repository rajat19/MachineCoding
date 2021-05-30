package com.paradox.parkingLot.models.vehicle;

import com.paradox.parkingLot.models.enums.VehicleType;

public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }
}
