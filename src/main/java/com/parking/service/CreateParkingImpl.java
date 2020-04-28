package com.parking.service;

import com.parking.exception.InvalidCommandException;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.utils.ErrorCodes;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class CreateParkingImpl implements CreateParking {

    static final String PARKING_CREATED_MESSAGE = "Created parking lot with %s slots";
    static final String PARKING_ALREADY_CREATED_ERROR_MESSAGE = "Parking cannot be created twice.";

    @Override
    public String createParking(Integer numberOfSlots) {

        // Checking condition if parking is already created.
        if(null!=ParkingSlotConfigurations.availableSlots){
            throw new InvalidCommandException(PARKING_ALREADY_CREATED_ERROR_MESSAGE, ErrorCodes.CREATE_PARKING_ERROR_CODE);
        }
        ParkingSlotConfigurations.totalNumbersOfSlots = numberOfSlots;
        ParkingSlotConfigurations.availableSlots = createAvailableSlots(numberOfSlots);
        return String.format(PARKING_CREATED_MESSAGE, numberOfSlots);

    }

    /**
     * Creating parking slots and putting in to a TreeSet.
     * @param numberOfSlots numbers of slots needs to be created in request.
     * @return TreeSet including slots.
     */
    private TreeSet<Integer> createAvailableSlots(Integer numberOfSlots) {
        TreeSet<Integer> availableSlots = new TreeSet<>();
        IntStream.range(1, numberOfSlots + 1)
                .forEach(availableSlots::add);
        return availableSlots;
    }
}
