package assessment.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Map<String, Integer> spotConfig = new HashMap<>();
        spotConfig.put(VehicleType.BIKE.getType(), 2);
        spotConfig.put(VehicleType.CAR.getType(), 3);
        spotConfig.put(VehicleType.TRUCK.getType(), 1);

        ParkingLot parkingLot = new ParkingLot(spotConfig);

        // Create vehicles
        Vehicle bike = new Bike("BIKE123");
        Vehicle car = new Car("CAR456");
        Vehicle truck = new Truck("TRUCK789");

        // Park vehicles
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);

        // Display available spots
        parkingLot.displayAvailableSpots();

        // Remove a vehicle
        parkingLot.removeVehicle("CAR456");

        // Display available spots again
        parkingLot.displayAvailableSpots();
    }
}