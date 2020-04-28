package test.service;


import com.parking.model.ParkingSlot;
import com.parking.model.ParkingSlotConfigurations;
import com.parking.model.Vehicle;
import com.parking.service.FetchParkingStatusImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FetchParkingStatusImplTest {


    @Before
    public void setup() {
        //first test data creation
        Vehicle vehicleTestData = Vehicle.builder()
                .registrationNumber("MH-14-AU3906")
                .color("Red")
                .build();
        ParkingSlot parkingSlotTestData = ParkingSlot.builder()
                .slotId(1)
                .vehicle(vehicleTestData)
                .build();
        //second test data creation
        Vehicle vehicleTestData2 = Vehicle.builder()
                .registrationNumber("KR-14-XY-0000")
                .color("White")
                .build();
        ParkingSlot parkingSlotTestData2 = ParkingSlot.builder()
                .slotId(2)
                .vehicle(vehicleTestData2)
                .build();
        ParkingSlotConfigurations.parkingStatus.put(1, parkingSlotTestData);
        ParkingSlotConfigurations.parkingStatus.put(2, parkingSlotTestData2);
    }

    @Test
    public void getParkingStatusTest() {

        String expectedResponse = "1\tMH-14-AU3906\n" +
                "2\tKR-14-XY-0000\n";
        String response = new FetchParkingStatusImpl().getParkingStatus();
        assertEquals("", expectedResponse,response);
    }

}
