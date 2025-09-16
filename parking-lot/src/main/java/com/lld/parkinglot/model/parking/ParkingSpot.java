package com.lld.parkinglot.model.parking;


import com.lld.parkinglot.enums.ParkingSpotType;
import com.lld.parkinglot.model.Vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class ParkingSpot {
    private final UUID id;
    private boolean isFree;
    private Vehicle vehicle;
    private final ParkingSpotType parkingSpotType;

    public ParkingSpot(UUID id, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
    }

    public abstract boolean assignVehicle(Vehicle vehicle);

    public boolean removeVehicle(){
        this.vehicle = null;
        this.isFree = true;
        return true;
    }
}
