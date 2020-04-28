package com.parking.service;

import com.parking.exception.InvalidCommandException;
import com.parking.model.ParkingSlot;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.model.Vehicle;
import com.parking.utils.ErrorCodes;

public class ParkImpl implements Park {

    private final static String ALLOCATION_MESSAGE = "Allocated slot number: ";
    private final static String PARKING_FULL_MESSAGE = "Sorry, parking lot is full";

    @Override
    public String doPark(String registrationNumber, String color) {

        /*
        Checking condition if we try to park before the Parking is created.
         */
        if (null == ParkingSlotConfigurations.availableSlots) {
            throw new InvalidCommandException("Parking is not yet created", ErrorCodes.PARKING_NOT_CREATED);
        }
        Integer nearestAvailableSlot = ParkingSlotConfigurations.availableSlots.pollFirst();
        if (nearestAvailableSlot == null) {
            return PARKING_FULL_MESSAGE;
        }
        Vehicle vehicle = Vehicle
                .builder()
                .color(color)
                .registrationNumber(registrationNumber)
                .build();
        ParkingSlot parkingSlot = ParkingSlot
                .builder()
                .slotId(nearestAvailableSlot)
                .vehicle(vehicle)
                .build();
        ParkingSlotConfigurations.parkingStatus.put(nearestAvailableSlot, parkingSlot);
        ParkingSlotConfigurations.registrationNumberParkingSlotMapping.put(registrationNumber, nearestAvailableSlot);
        return ALLOCATION_MESSAGE + nearestAvailableSlot;
    }
}
