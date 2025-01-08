package assessment.parkingLot.multiFloor;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// Represents an entrance to the parking lot
// Main class to run the simulation
public class Main {
    public static void main(String[] args) {
        int numFloors = 3;
        int slotsPerFloor = 5;
        int numEntrances = 2;

        ParkingLot parkingLot = new ParkingLot(numFloors, slotsPerFloor);
        ExecutorService executorService = Executors.newFixedThreadPool(numEntrances);

        for (int i = 1; i <= numEntrances; i++) {
            executorService.execute(new Entrance(parkingLot, i));
        }

        executorService.shutdown();
    }
}

