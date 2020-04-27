package com.parking.service;

import com.parking.model.ParkingSlot;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.model.Vehicle;

public class ParkImpl implements Park{

    private final static String ALLOCATION_MESSAGE = "Allocated slot number: ";
    @Override
    public String doPark(String registrationNumber, String color) {

        Integer nearestAvailableSlot = ParkingSlotConfigurations.availableSlots.pollFirst();
        if(nearestAvailableSlot==null){
            return "Sorry, parking lot is full";
        }
        ParkingSlot parkingSlot = new ParkingSlot();
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(color);
        vehicle.setRegistrationNumber(registrationNumber);
        parkingSlot.setSlotId(nearestAvailableSlot);
        parkingSlot.setVehicle(vehicle);
        ParkingSlotConfigurations.parkingStatus.put(nearestAvailableSlot, parkingSlot);
        ParkingSlotConfigurations.registrationNumberParkingSlotMapping.put(registrationNumber, nearestAvailableSlot);
        return ALLOCATION_MESSAGE+nearestAvailableSlot;
    }
}
