package com.parking;

import com.parking.service.CreateParkingImpl;
import com.parking.service.FetchParkingStatusImpl;
import com.parking.service.LeaveImpl;
import com.parking.service.ParkImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ApplicationStarter {


    public static void main(String[] args) {

        File f = new File("src/main/resources/parking.txt");
        String readLine = "";
        StringBuilder outPutLine = new StringBuilder();
        try {

            BufferedReader b = new BufferedReader(new FileReader(f));

            while ((readLine = b.readLine()) != null) {
                List<String> input = List.of(readLine.split(" "));
                String outPut = performAction(input);
                outPutLine.append(outPut).append("\n");
            }

            System.out.println(outPutLine);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String performAction(List<String> command) {

        switch (command.get(0)){
            case "create_parking_lot":
                return new CreateParkingImpl().createParking(Integer.parseInt(command.get(1)));
            case "park":
                return new ParkImpl().doPark(command.get(1), "Red");
            case "leave":
                return new LeaveImpl().leave(command.get(1), Integer.parseInt(command.get(2)));
            case "status":
                return new FetchParkingStatusImpl().getParkingStatus();
            default:
                throw new RuntimeException("Invalid command in input file");
        }
    }
}
