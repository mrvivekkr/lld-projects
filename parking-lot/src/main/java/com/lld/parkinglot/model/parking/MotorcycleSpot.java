package com.lld.parkinglot.model.parking;


import com.lld.parkinglot.enums.ParkingSpotType;
import com.lld.parkinglot.model.Vehicle.Vehicle;

import java.util.UUID;

public class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot(final UUID id, final ParkingSpotType parkingSpotType) {
        super(id, parkingSpotType);
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        return false;
    }
}
