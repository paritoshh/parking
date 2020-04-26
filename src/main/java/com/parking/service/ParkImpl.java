package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

public class ParkImpl implements Park{

    private final static String ALLOCATION_MESSAGE = "Allocated slot number: ";
    @Override
    public String doPark(String registrationNumber) {

        Integer nearestAvailableSlot = ParkingSlotConfigurations.availableSlots.pollFirst();
        ParkingSlotConfigurations.parkingStatus.put(registrationNumber, nearestAvailableSlot);
        return ALLOCATION_MESSAGE+nearestAvailableSlot;
    }
}
