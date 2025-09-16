package com.lld.parkinglot.model.parking;


import com.lld.parkinglot.enums.ParkingSpotType;
import com.lld.parkinglot.exception.SlotNotAvailableException;
import com.lld.parkinglot.model.Vehicle.Vehicle;
import com.lld.parkinglot.enums.VehicleType;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Getter
public class ParkingFloor {

    private final int floorId;
    private final  Map<ParkingSpotType, Queue<ParkingSpot>> availableSpotsByType;
    private final Map<ParkingSpotType, Set<ParkingSpot>> occupiedSpotsByType;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
        availableSpotsByType = new HashMap<ParkingSpotType, Queue<ParkingSpot>>();
        availableSpotsByType.put(ParkingSpotType.COMPACT, new ConcurrentLinkedQueue<>());
        availableSpotsByType.put(ParkingSpotType.LARGE, new ConcurrentLinkedQueue<>());
        availableSpotsByType.put(ParkingSpotType.MOTORBIKE, new ConcurrentLinkedQueue<>());
        availableSpotsByType.put(ParkingSpotType.HANDICAPPED, new ConcurrentLinkedQueue<>());

        occupiedSpotsByType = new HashMap<ParkingSpotType, Set<ParkingSpot>>();
    }

    public synchronized ParkingSpot assignParkingSpotToVehicle(Vehicle vehicle) throws SlotNotAvailableException {
        ParkingSpotType parkingSpotType = getParkingSpotType(vehicle.getVehicleType());
        if(!isParkingSlotAvailable(parkingSpotType)){
            throw new SlotNotAvailableException("No Slot Available");
        }
        ParkingSpot spot = availableSpotsByType.get(parkingSpotType).poll();
        spot.assignVehicle(vehicle);
        occupiedSpotsByType.computeIfAbsent(parkingSpotType, k->new HashSet<>()).add(spot);
        return spot;
    }

    public boolean isParkingSlotAvailable(ParkingSpotType parkingSpotType) {
        return availableSpotsByType.get(parkingSpotType).size()>0;
    }

    public boolean canPark(Vehicle vehicle){
        ParkingSpotType parkingSpotType = getParkingSpotType(vehicle.getVehicleType());
        return availableSpotsByType.get(parkingSpotType).size()>0;
    }

    private ParkingSpotType getParkingSpotType(VehicleType vehicleType) {
        switch (vehicleType){
            case CAR:
                return ParkingSpotType.COMPACT;
            case MOTORCYCLE:
                return ParkingSpotType.MOTORBIKE;
            default:
                return ParkingSpotType.LARGE;
        }

    }

    public boolean vacateSpot(final ParkingSpot spot) {
        ParkingSpotType parkingSpotType = spot.getParkingSpotType();
        Set<ParkingSpot> parkingSpots =  occupiedSpotsByType.get(parkingSpotType);
        if(parkingSpots!=null && parkingSpots.remove(spot)){
            spot.removeVehicle();
            spot.setFree(true);
            availableSpotsByType.get(parkingSpotType).add(spot);
            return true;
        }
        return false;
    }

    public void addParkingSpot(final ParkingSpot spot) {
        if (spot == null) {
            throw new IllegalArgumentException("spot cannot be null");
        }
        ParkingSpotType type = spot.getParkingSpotType();
        if (type == null) {
            throw new IllegalArgumentException("ParkingSpotType must be set on the spot before adding to floor");
        }

        // ensure the queue exists (constructor already created keys, but keep safe)
        Queue<ParkingSpot> queue = availableSpotsByType.get(type);
        if (queue == null) {
            queue = new LinkedList<>();
            availableSpotsByType.put(type, queue);
        }

        // mark free and add
        spot.setFree(true);
        queue.add(spot);
    }
}
