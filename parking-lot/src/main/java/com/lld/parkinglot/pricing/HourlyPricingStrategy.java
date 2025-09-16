package com.lld.parkinglot.pricing;

import com.lld.parkinglot.model.Ticket.ParkingTicket;

import java.time.Duration;
import java.time.Instant;

public class HourlyPricingStrategy implements PricingStrategy{
    private static final double PRICE_PER_HOUR = 1.0;
    @Override
    public double calculateAmount(final ParkingTicket parkingTicket) {
        Instant entryInstant = parkingTicket.getEntryTime().toInstant();
        Instant exitInstant = parkingTicket.getExitTime().toInstant();
        long hoursParked = Duration.between(entryInstant, exitInstant).toHours();
        return PRICE_PER_HOUR*hoursParked;
    }
}
