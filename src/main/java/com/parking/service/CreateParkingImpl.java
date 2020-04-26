package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class CreateParkingImpl implements CreateParking {

    @Override
    public void createParking(Integer numberOfSlots) {

        ParkingSlotConfigurations.totalNumbersOfSlots = numberOfSlots;
       // ParkingSlotConfigurations.availableNumbersOfSlots = numberOfSlots;
        ParkingSlotConfigurations.availableSlots = createAvailableSlots(numberOfSlots);

    }

    private TreeSet<Integer> createAvailableSlots(Integer numberOfSlots){
        TreeSet<Integer> availableSlots = new TreeSet<>();
        IntStream.range(1,numberOfSlots+1)
                .forEach(availableSlots::add);
        return availableSlots;
    }
}
