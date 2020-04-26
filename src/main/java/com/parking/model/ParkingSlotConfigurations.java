package com.parking.model;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ParkingSlotConfigurations {

    public static int totalNumbersOfSlots;
    public static TreeSet<Integer> availableSlots;
    public static SortedMap<Integer, ParkingSlot> parkingStatus = new TreeMap<>();
}
