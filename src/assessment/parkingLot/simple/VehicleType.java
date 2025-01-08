package assessment.parkingLot.simple;

public enum VehicleType {
    CAR("Car"),
    BIKE("Bike"),
    TRUCK("Truck");

    private String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
