package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

public class FetchParkingStatusImpl implements FetchParkingStatus {
    @Override
    public String getParkingStatus() {

        StringBuilder parkingStatus = new StringBuilder();
        /*
        Mapping the status response in the required format.
         */
        ParkingSlotConfigurations.parkingStatus.values().forEach(parkingMap ->
            parkingStatus.append(parkingMap.getSlotId()).append("\t").append(parkingMap.getVehicle().getRegistrationNumber()).append("\n")
        );
        return parkingStatus.toString();
    }
}
