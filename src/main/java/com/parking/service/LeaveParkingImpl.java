package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

public class LeaveParkingImpl implements LeaveParking {
    private final static String VEHICLE_NOT_FOUND_ERROR_MESSAGE = "Registration number %s not found";
    private final static String LEAVE_MESSAGE = "Registration number %1$s with Slot Number %2$s is free with Charge %3$.0f";

    private final static int NUMBER_OF_FIRST_COMBINED_DAYS = 2;
    private final static double CHARGE_FOR_FIRST_COMBINED_DAYS = 10;
    private final static double CHARGE_FOR_NEXT_EACH_DAY = 10;

    @Override
    public String leave(String registrationNumber, int parkedHours) {


        Integer assignedParkingSlotToBeAvailable = ParkingSlotConfigurations.registrationNumberParkingSlotMapping.remove(registrationNumber);
        if (null == assignedParkingSlotToBeAvailable) {
            return String.format(VEHICLE_NOT_FOUND_ERROR_MESSAGE, registrationNumber);
        }
        ParkingSlotConfigurations.availableSlots.add(assignedParkingSlotToBeAvailable);
        ParkingSlotConfigurations.parkingStatus.remove(assignedParkingSlotToBeAvailable);
        return String.format(LEAVE_MESSAGE, registrationNumber, assignedParkingSlotToBeAvailable, calculateCharge(parkedHours));
    }

    /**
     * This method is calculating the parking charge.
     * Charge applicable is $10 for first 2 hours and $10 for every additional
     * hour.
     *
     * @param parkedHours slot consumed hours by any vehicle
     * @return parking charge
     */
    private double calculateCharge(int parkedHours) {
        int hoursAfterFirstCombinedAllowedHours = parkedHours - NUMBER_OF_FIRST_COMBINED_DAYS;
        return hoursAfterFirstCombinedAllowedHours > 0 ? CHARGE_FOR_FIRST_COMBINED_DAYS + (hoursAfterFirstCombinedAllowedHours * CHARGE_FOR_NEXT_EACH_DAY) : CHARGE_FOR_FIRST_COMBINED_DAYS;
    }
}