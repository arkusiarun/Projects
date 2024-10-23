package assessment.carRental;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing vehicles
public abstract class Vehicle {
    private String licenseNumber;
    private String stockNumber;
    private int passengerCapacity;
    private String barcode;
    private boolean hasSunroof;
    private VehicleStatus status;
    private String model;
    private String make;
    private int manufacturingYear;
    private int mileage;

    private List<VehicleLog> log = new ArrayList<>();

    public boolean reserveVehicle() {
        this.status = VehicleStatus.RESERVED;
        System.out.println("Vehicle reserved.");
        return true;
    }

    public boolean returnVehicle() {
        this.status = VehicleStatus.AVAILABLE;
        System.out.println("Vehicle returned.");
        return true;
    }

    public List<VehicleLog> getLog() {
        return log;
    }
}
