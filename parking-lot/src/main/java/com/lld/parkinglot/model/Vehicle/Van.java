package com.lld.parkinglot.model.Vehicle;

import com.lld.parkinglot.enums.VehicleType;

public class Van extends Vehicle {

    public Van(final String licenseNo){
        super(licenseNo, VehicleType.VAN);
    }
}
