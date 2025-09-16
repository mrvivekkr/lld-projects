package com.lld.parkinglot.pricing;

import com.lld.parkinglot.model.Ticket.ParkingTicket;

public interface PricingStrategy {
    double calculateAmount(ParkingTicket parkingTicket);
}
