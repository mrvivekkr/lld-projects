package com.lld.parkinglot.application;

import com.lld.parkinglot.enums.ParkingSpotType;
import com.lld.parkinglot.exception.ParkingFullException;
import com.lld.parkinglot.exception.SlotNotAvailableException;
import com.lld.parkinglot.model.Ticket.ParkingTicket;
import com.lld.parkinglot.model.Vehicle.Car;
import com.lld.parkinglot.model.Vehicle.Vehicle;
import com.lld.parkinglot.model.panel.Entrance;
import com.lld.parkinglot.model.panel.Exit;
import com.lld.parkinglot.model.parking.*;
import com.lld.parkinglot.pricing.HourlyPricingStrategy;

import java.util.List;
import java.util.UUID;

public class Application {
    public static void main(String[] args) throws SlotNotAvailableException, ParkingFullException {
        System.out.println("\n====================== PARKING LOT SYSTEM DEMO ======================\n");

        // Setup ParkingLot singleton
        ParkingLot lot = ParkingLot.getInstance();
        lot.setId(UUID.randomUUID());
        lot.setName("Parking Lot");

        // Create Floors
        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);

        // Add 2 spots of each type on each floor
        addDefaultSpotsToFloor(floor1);
        addDefaultSpotsToFloor(floor2);

        lot.setParkingFloors(List.of(floor1,floor2));

        lot.setPricingStrategy(new HourlyPricingStrategy());

        // Setup entrances and exits
        Entrance entrance1 = new Entrance(1);
        Entrance entrance2 = new Entrance(2);
        Exit exit1 = new Exit(1);
        Exit exit2 = new Exit(2);
        lot.setEntranceGates(List.of(entrance1,entrance2));
        lot.setExitGates(List.of(exit1,exit2));

        // ----------------- SCENARIO 1: CUSTOMER ENTERS, PARKS -----------------
        System.out.println("\n→→→ SCENARIO 1: Customer enters and parks a car\n");
        Vehicle car = new Car("KA-01-HH-1234");
        ParkingTicket ticket1 = entrance1.getParkingTicket(car);
        lot.displayAvailableSlots();

        // ----------------- SCENARIO 2: CUSTOMER EXITS -------- -----------------
        System.out.println("\n→→→ SCENARIO 2: Customer exits and pays\n");
        exit2.scanAndVacate(ticket1);
        lot.displayAvailableSlots();

        // --------- SCENARIO 3: FILLING LOT AND REJECTING ENTRY IF FULL ---------
        System.out.println("\n→→→ SCENARIO 3: Multiple customers attempt to enter; lot may become full\n");
        try {
            for (int i = 0; i < 20; i++) {
                Vehicle v = new Car("KA-01-HH-" + (2000 + i));
                ParkingTicket t = entrance1.getParkingTicket(v);
                System.out.println("Parked " + v.getVehicleType() + " at spot: " + t.getSpot().getId());
            }
        } catch (ParkingFullException e) {
            System.out.println("Lot is full! Cannot park more vehicles.");
        }
        lot.displayAvailableSlots();

        System.out.println("\n====================== END OF DEMONSTRATION ======================\n");

    }

    private static void addDefaultSpotsToFloor(ParkingFloor floor) {
        for (int i = 1; i <= 2; i++) {
            floor.addParkingSpot(new CompactSpot(UUID.randomUUID(), ParkingSpotType.COMPACT));
            floor.addParkingSpot(new LargeSpot(UUID.randomUUID(), ParkingSpotType.LARGE));
            floor.addParkingSpot(new HandicappedSpot(UUID.randomUUID(), ParkingSpotType.HANDICAPPED));
            floor.addParkingSpot(new MotorcycleSpot(UUID.randomUUID(), ParkingSpotType.MOTORBIKE));
        }
    }
}
