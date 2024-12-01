package assessment.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        // Configure parking lot: 2 motorcycle spots, 3 car spots, 1 truck spot
        Map<String, Integer> spotConfig = new HashMap<>();
        spotConfig.put("Motorcycle", 2);
        spotConfig.put("Car", 3);
        spotConfig.put("Truck", 1);
        spotConfig.put("ElectricCar", 2);

        ParkingLot parkingLot = new ParkingLot(spotConfig);

        // Create vehicles
        Vehicle motorcycle = new Vehicle("Motorcycle", "MOTO123");
        Vehicle car = new Vehicle("Car", "CAR456");
        Vehicle truck = new Vehicle("Truck", "TRUCK789");
        Vehicle electricCar = new Vehicle("ElectricCar", "ELECTRIC999");

        // Park vehicles
        parkingLot.parkVehicle(motorcycle);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(electricCar);

        // Display available spots
        parkingLot.displayAvailableSpots();

        // Remove a vehicle
        parkingLot.removeVehicle("CAR456");

        // Display available spots again
        parkingLot.displayAvailableSpots();
    }
}