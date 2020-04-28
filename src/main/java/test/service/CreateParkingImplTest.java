package test.service;

import com.parking.exception.InvalidCommandException;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.service.CreateParkingImpl;
import org.junit.After;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CreateParkingImplTest {

    @Test
    public void createParkingTest_already_crated_error_scenario() {
        ParkingSlotConfigurations.availableSlots = new TreeSet<>();

        InvalidCommandException thrown = assertThrows(InvalidCommandException.class,
                () -> new CreateParkingImpl().createParking(4));

        assertEquals("Wrong error message in createParkingTest_already_crated_error_scenario", "Parking cannot be created twice.", thrown.getErrorMessage());
        assertEquals("Wrong error code in createParkingTest_already_crated_error_scenario", "ERR001", thrown.getErrorCode());

    }
    @After
    public void tearDown(){
        ParkingSlotConfigurations.availableSlots = null;
    }

    @Test
    public void createParking_success_scenario() {

        String expected = "Created parking lot with 10 slots";
        String response = new CreateParkingImpl().createParking(10);

        assertEquals("Slots are not created", 10, ParkingSlotConfigurations.totalNumbersOfSlots);
        assertEquals("Create parking scenario failing", expected, response);
        assertEquals("Slots are not created", 10, ParkingSlotConfigurations.availableSlots.size());
        assertEquals("Position of first parking slot is not correct", "1", ParkingSlotConfigurations.availableSlots.first().toString());
        assertEquals("Position of last parking slot is not correct", "10", ParkingSlotConfigurations.availableSlots.last().toString());
    }
}
