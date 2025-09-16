package com.lld.parkinglot.model.panel;

import com.lld.parkinglot.model.Ticket.ParkingTicket;
import com.lld.parkinglot.model.parking.ParkingLot;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Exit {
    public int id;

    public void scanAndVacate(ParkingTicket parkingTicket){
        parkingTicket.setExitTime(new Date());
        ParkingLot parkinglot = ParkingLot.getInstance();
        parkinglot.calculateAmount(parkingTicket);
        parkinglot.vacateParkingSpot(parkingTicket.getSpot());
    }
}
