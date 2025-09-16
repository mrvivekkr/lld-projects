package com.lld.parkinglot.model.Vehicle;


import com.lld.parkinglot.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(final String licenceNo){
        super(licenceNo, VehicleType.TRUCK);
    }
}
