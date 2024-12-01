package assessment.parkingLot;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public String getType() {
        return VehicleType.CAR.getType();
    }
}

