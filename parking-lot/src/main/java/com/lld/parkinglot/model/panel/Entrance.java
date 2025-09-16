package com.lld.parkinglot.model.panel;


import com.lld.parkinglot.exception.ParkingFullException;
import com.lld.parkinglot.exception.SlotNotAvailableException;
import com.lld.parkinglot.model.Ticket.ParkingTicket;
import com.lld.parkinglot.model.Vehicle.Vehicle;
import com.lld.parkinglot.model.parking.ParkingLot;
import com.lld.parkinglot.model.parking.ParkingSpot;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
public class Entrance {
    public int id;

    public ParkingTicket getParkingTicket(final Vehicle vehicle) throws SlotNotAvailableException, ParkingFullException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpot parkingSpot =  parkingLot.getParkingSpot(vehicle);
        return buildParkingTicket(vehicle, parkingSpot);
    }

    private ParkingTicket buildParkingTicket(final Vehicle vehicle, final ParkingSpot parkingSpot) {
        return ParkingTicket.builder()
                .id(UUID.randomUUID())
                .vehicle(vehicle)
                .spot(parkingSpot)
                .entryTime(new Date())
                .build();
    }
}
