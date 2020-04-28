package com.parking;

import com.parking.exception.InvalidCommandException;
import com.parking.service.CreateParkingImpl;
import com.parking.service.FetchParkingStatusImpl;
import com.parking.service.LeaveParkingImpl;
import com.parking.service.ParkImpl;
import com.parking.utils.ErrorCodes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStarter {

    private static final String INPUT_FILE_LOCATION = "src/main/resources/file_inputs.txt";
    private static final String CREATE_PARKING_COMMAND = "create_parking_lot";
    private static final String ASSIGN_PARKING_SLOT_COMMAND = "park";
    private static final String LEAVE_PARKING_COMMAND = "leave";
    private static final String PARKING_STATUS_COMMAND = "status";
    /*
    You can specify the number of parking gates, and same number of threads will be started.
    This value is totally configurable.
     */
    private static final int NUMBER_OF_PARKING_GATES = 2;

    public static void main(String[] args) {

        /*
        Creating the number of threads in case of multiple gates are required for the parking system.
        We can use the input_file with a huge amount of data and test the improvement in performance by putting SLA logs.
        (Sample input file is attached in resources folder).
         */
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_PARKING_GATES);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                readInputCommandFile();
            }
        });

        executorService.shutdown();

    }

    /**
     * Reading input file and call respective services and printing response in SYSOUT.
     */
    private static void readInputCommandFile() {
        File file = new File(INPUT_FILE_LOCATION);
        String readLine = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((readLine = bufferedReader.readLine()) != null) {
                List<String> input = List.of(readLine.split(" "));
                System.out.println(performAction(input));
            }
        } catch (IOException e) {
            throw new RuntimeException("IO Exception occurred in parking input file.");
        }
    }

    /**
     * This method is checking for command and calling respective service for action.
     * Here color of vehicle is set to Red for each vehicle.
     *
     * @param command action in parking
     * @return task completion message for output
     */
    private static String performAction(List<String> command) {

        switch (command.get(0)) {
            case CREATE_PARKING_COMMAND:
                return new CreateParkingImpl().createParking(Integer.parseInt(command.get(1)));
            case ASSIGN_PARKING_SLOT_COMMAND:
                return new ParkImpl().doPark(command.get(1), "Red");
            case LEAVE_PARKING_COMMAND:
                return new LeaveParkingImpl().leave(command.get(1), Integer.parseInt(command.get(2)));
            case PARKING_STATUS_COMMAND:
                return new FetchParkingStatusImpl().getParkingStatus();
            default:
                throw new InvalidCommandException("Invalid command in input file", ErrorCodes.INVALID_COMMAND_ERROR_CODE);
        }
    }
}