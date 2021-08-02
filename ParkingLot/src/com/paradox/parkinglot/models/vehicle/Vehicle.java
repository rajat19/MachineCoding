package com.paradox.parkinglot.models.vehicle;

import com.paradox.parkinglot.models.enums.VehicleType;

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
