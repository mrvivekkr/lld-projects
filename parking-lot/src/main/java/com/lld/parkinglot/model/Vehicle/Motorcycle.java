package com.lld.parkinglot.model.Vehicle;


import com.lld.parkinglot.enums.VehicleType;

public class Motorcycle extends Vehicle {

    public Motorcycle(final String licenseNo){
        super(licenseNo, VehicleType.MOTORCYCLE);
    }
}
