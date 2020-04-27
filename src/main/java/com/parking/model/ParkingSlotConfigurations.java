package com.parking.model;

import java.util.*;

public class ParkingSlotConfigurations {

    public static int totalNumbersOfSlots;
    public static TreeSet<Integer> availableSlots;
    public static SortedMap<Integer, ParkingSlot> parkingStatus = new TreeMap<>();
    public static Map<String, Integer> registrationNumberParkingSlotMapping = new HashMap<>();
}
