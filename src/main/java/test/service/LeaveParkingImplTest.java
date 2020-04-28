package test.service;

import com.parking.model.ParkingSlot;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.model.Vehicle;
import com.parking.service.LeaveParkingImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class LeaveParkingImplTest {

    private final String REGISTRATION_NUMBER_01 = "MH-XXX-0001";
    private final String REGISTRATION_NUMBER_02 = "MH-XXX-0002";
    private final String REGISTRATION_NUMBER_03 = "MH-XXX-0003";

    @Before
    public void setup() {
        Map<String, Integer> registrationNumberParkingSlotMapping = new HashMap<>();
        registrationNumberParkingSlotMapping.put(REGISTRATION_NUMBER_02, 2);
        registrationNumberParkingSlotMapping.put(REGISTRATION_NUMBER_03, 3);
        ParkingSlotConfigurations.registrationNumberParkingSlotMapping = registrationNumberParkingSlotMapping;

        ParkingSlotConfigurations.availableSlots = new TreeSet<>();
        ParkingSlotConfigurations.availableSlots.add(3);

        Vehicle vehicle = Vehicle.builder()
                .registrationNumber(REGISTRATION_NUMBER_01)
                .color("Red")
                .build();
        ParkingSlot parkingSlot = ParkingSlot.builder()
                .vehicle(vehicle)
                .slotId(3)
                .build();
        ParkingSlotConfigurations.parkingStatus.put(3, parkingSlot);
    }

    @After
    public void tearDown(){
        ParkingSlotConfigurations.registrationNumberParkingSlotMapping.clear();
        ParkingSlotConfigurations.availableSlots = null;
        ParkingSlotConfigurations.parkingStatus.clear();
    }

    @Test
    public void leaveTest_vehicle_not_found_scenario() {
        String expected = "Registration number MH-XXX-0001 not found";
        String response = new LeaveParkingImpl().leave(REGISTRATION_NUMBER_01, 4);
        assertEquals("Wrong error message in leaveTest_vehicle_not_found_scenario", expected, response);
    }

    @Test
    public void leaveTest_success_scenario() {
        String expected = "Registration number MH-XXX-0003 with Slot Number 3 is free with Charge 30";
        String response = new LeaveParkingImpl().leave(REGISTRATION_NUMBER_03, 4);
        assertEquals("Wrong error message in leaveTest_success_scenario", expected, response);

    }
}