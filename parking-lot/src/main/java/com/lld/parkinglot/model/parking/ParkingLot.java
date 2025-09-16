package com.lld.parkinglot.model.parking;


import com.lld.parkinglot.common.Address;
import com.lld.parkinglot.enums.ParkingSpotType;
import com.lld.parkinglot.exception.ParkingFullException;
import com.lld.parkinglot.exception.SlotNotAvailableException;
import com.lld.parkinglot.model.Ticket.ParkingTicket;
import com.lld.parkinglot.model.Vehicle.Vehicle;
import com.lld.parkinglot.model.panel.Entrance;
import com.lld.parkinglot.model.panel.Exit;
import com.lld.parkinglot.pricing.PricingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ParkingLot {

    //Singleton Initialization of Parking lot
    private ParkingLot(){}
    private static volatile ParkingLot parkingLot = null;
    public static ParkingLot getInstance(){
        if (parkingLot == null) {
            synchronized (ParkingLot.class) {
                if (parkingLot == null) {
                    parkingLot = new ParkingLot();
                }
            }
        }
        return parkingLot;
    }

    private PricingStrategy pricingStrategy;

    private UUID id;
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private List<Entrance> entranceGates;
    private List<Exit> exitGates;


    public ParkingSpot getParkingSpot(Vehicle vehicle) throws ParkingFullException, SlotNotAvailableException {
        Optional<ParkingFloor> parkingFloor = parkingFloors.stream().filter(floor->floor.canPark(vehicle)).findFirst();
        if(!parkingFloor.isPresent()){
            throw new ParkingFullException("Sorry! Parking is full");
        }
        return parkingFloor.get().assignParkingSpotToVehicle(vehicle);
    }

    public void calculateAmount(final ParkingTicket parkingTicket) {
        double amount = pricingStrategy.calculateAmount(parkingTicket);
        parkingTicket.setCharge(amount);
    }

    public void vacateParkingSpot(final ParkingSpot spot) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.vacateSpot(spot)) {
                break;
            }
        }

    }

    public void displayAvailableSlots() {
        Map<ParkingSpotType, Integer> availableSlotsCount = new HashMap<>();
        for (ParkingSpotType type : ParkingSpotType.values()) {
            availableSlotsCount.put(type, 0);
        }

        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpotType type : ParkingSpotType.values()) {
                int available = floor.isParkingSlotAvailable(type) ? floor.getAvailableSpotsByType().get(type).size() : 0;
                availableSlotsCount.put(type, availableSlotsCount.get(type) + available);
            }
        }

        System.out.println("Available parking slots by type:");
        for (ParkingSpotType type : ParkingSpotType.values()) {
            System.out.println(type + ": " + availableSlotsCount.get(type));
        }
    }

}
