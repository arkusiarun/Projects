package assessment.parkingLot;

public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public String getType() {
        return VehicleType.BIKE.getType();
    }
}