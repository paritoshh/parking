package com.parking.service;

import com.parking.model.ParkingSlotConfigurations;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class CreateParkingImpl implements CreateParking {

    static final String PARKING_CREATED_MESSAGE = "Created parking lot with %s slots";
    @Override
    public String createParking(Integer numberOfSlots) {

        ParkingSlotConfigurations.totalNumbersOfSlots = numberOfSlots;
       // ParkingSlotConfigurations.availableNumbersOfSlots = numberOfSlots;
        ParkingSlotConfigurations.availableSlots = createAvailableSlots(numberOfSlots);
        return String.format(PARKING_CREATED_MESSAGE, numberOfSlots);

    }

    private TreeSet<Integer> createAvailableSlots(Integer numberOfSlots){
        TreeSet<Integer> availableSlots = new TreeSet<>();
        IntStream.range(1,numberOfSlots+1)
                .forEach(availableSlots::add);
        return availableSlots;
    }
}
