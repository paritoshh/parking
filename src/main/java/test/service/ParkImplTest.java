package test.service;

import com.parking.exception.InvalidCommandException;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.service.ParkImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class ParkImplTest {

    @Before
    public void setup() {
        ParkingSlotConfigurations.availableSlots = new TreeSet();
    }

    @After
    public void tearDown() {
        ParkingSlotConfigurations.availableSlots = null;
    }

    @Test
    public void doParkTest_already_full_parking() {
        String expected = "Sorry, parking lot is full";
        String response = new ParkImpl().doPark("MH-XX-000", "Red");
        assertEquals("Already full parking scenario failing", expected, response);

    }

    @Test
    public void doParkTest_success_scenario() {
        ParkingSlotConfigurations.availableSlots.add(2);
        String expected = "Allocated slot number: 2";
        String response = new ParkImpl().doPark("MH-XX-000", "Red");
        assertEquals("Parking success scenario failing", expected, response);
        assertNotNull("parkingStatus is not populated in parking scenario", ParkingSlotConfigurations.parkingStatus);
        assertNotNull("registrationNumberParkingSlotMapping is not populated in parking scenario", ParkingSlotConfigurations.registrationNumberParkingSlotMapping);
    }

    @Test
    public void doParkTest_parking_not_created_exception_scenario() {
        InvalidCommandException thrown = assertThrows(InvalidCommandException.class,
                () -> {
                    ParkingSlotConfigurations.availableSlots = null;
                    new ParkImpl().doPark("MH-XX-000", "Red");
                });
        assertEquals("Wrong error message in parking_not_created_exception_scenario", "Parking is not yet created", thrown.getErrorMessage());
        assertEquals("Wrong error code in parking_not_created_exception_scenario", "ERR003", thrown.getErrorCode());
    }
}