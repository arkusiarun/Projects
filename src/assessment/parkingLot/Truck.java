package assessment.parkingLot;

// Truck class (inherits Vehicle)
public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public String getType() {
        return VehicleType.TRUCK.getType();
    }
}
