package com.lld.parkinglot.model.Vehicle;


import com.lld.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(final String licenseNo){
        super(licenseNo, VehicleType.CAR);
    }
}
