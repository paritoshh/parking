package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

public class LeaveImpl implements Leave{
    private final static String LEAVE_MESSAGE_PART_1 = "Registration number ";
    private final static String LEAVE_MESSAGE_PART_2 = "with Slot Number ";
    private final static String LEAVE_MESSAGE_PART_3 ="is free with Charge";

    private final static int NUMBER_OF_FIRST_COMBINED_DAYS = 2;
    private final static double CHARGE_FOR_FIRST_COMBINED_DAYS = 10;
    private final static double CHARGE_FOR_NEXT_EACH_DAY = 10;

    @Override
    public String leave(String registrationNumber, int parkedHours) {
        Integer assignedParkingSlotToBeAvailable = ParkingSlotConfigurations.parkingStatus.get(registrationNumber);
        ParkingSlotConfigurations.availableSlots.add(assignedParkingSlotToBeAvailable);
        return LEAVE_MESSAGE_PART_1+registrationNumber+LEAVE_MESSAGE_PART_2+assignedParkingSlotToBeAvailable+LEAVE_MESSAGE_PART_3+calculateCharge(parkedHours);
    }

    /**
     *
     * @param parkedHours
     * @return
     */
    private double calculateCharge(int parkedHours) {
        int hoursAfterFirstCombinedAllowedHours = parkedHours-NUMBER_OF_FIRST_COMBINED_DAYS;
        return hoursAfterFirstCombinedAllowedHours>0?CHARGE_FOR_FIRST_COMBINED_DAYS+(hoursAfterFirstCombinedAllowedHours*CHARGE_FOR_NEXT_EACH_DAY):CHARGE_FOR_FIRST_COMBINED_DAYS;
    }
}
