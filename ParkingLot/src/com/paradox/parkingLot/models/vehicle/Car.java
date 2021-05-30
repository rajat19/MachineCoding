package com.paradox.parkingLot.models.vehicle;

import com.paradox.parkingLot.models.enums.VehicleType;
import com.paradox.parkingLot.models.vehicle.Vehicle;

public class Car extends Vehicle {
    public Car() {
        super(VehicleType.CAR);
    }
}
