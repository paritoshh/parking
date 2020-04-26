package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

public class FetchParkingStatusImpl implements FetchParkingStatus{
    @Override
    public String getParkingStatus() {

        ParkingSlotConfigurations.parkingStatus.put("a", 2);
        ParkingSlotConfigurations.parkingStatus.put("e", 3);
        ParkingSlotConfigurations.parkingStatus.put("c", 6);
        ParkingSlotConfigurations.parkingStatus.put("d", 1);
        ParkingSlotConfigurations.parkingStatus.put("a", 27);
        String status = ParkingSlotConfigurations.parkingStatus.values().toString();
        System.out.print(status);
        return ParkingSlotConfigurations.parkingStatus.toString();
    }

    /*public static void main(String[] args) {
        new FetchParkingStatusImpl().getParkingStatus();
    }*/
}
