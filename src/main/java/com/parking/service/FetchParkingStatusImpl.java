package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

public class FetchParkingStatusImpl implements FetchParkingStatus{
    @Override
    public String getParkingStatus() {

        String status = ParkingSlotConfigurations.parkingStatus.values().toString();
        System.out.print(status);
        return ParkingSlotConfigurations.parkingStatus.toString();
    }
}
