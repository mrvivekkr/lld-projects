package com.lld.parkinglot.model.Ticket;

import com.lld.parkinglot.model.Vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

import com.lld.parkinglot.model.parking.ParkingSpot;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ParkingTicket {
    private UUID id;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private Date entryTime;
    @Setter
    private Date exitTime;
    @Setter
    private Double charge;
}
