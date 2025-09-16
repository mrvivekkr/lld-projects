package com.lld.parkinglot.model.Vehicle;


import com.lld.parkinglot.enums.VehicleType;
import com.lld.parkinglot.model.Ticket.ParkingTicket;
import lombok.Getter;

public abstract class Vehicle {

    private final String licenseNo;
    private ParkingTicket ticket;
    @Getter
    private final VehicleType vehicleType;

    public Vehicle(final String licenseNo, final VehicleType vehicleType) {
        this.licenseNo = licenseNo;
        this.vehicleType = vehicleType;
    }

    public  void assignTicket(final ParkingTicket ticket){
        this.ticket = ticket;
    }
}
