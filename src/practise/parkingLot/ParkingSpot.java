package practise.parkingLot;

class ParkingSpot {
    private int number;
    private VehicleType type;
    private Vehicle currentVehicle;

    public ParkingSpot(int number, VehicleType type) {
        this.number = number;
        this.type = type;
        this.currentVehicle = null;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }

    public boolean park(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType() == type) {
            currentVehicle = vehicle;
            return true;
        }
        return false;
    }

    public Vehicle leave() {
        Vehicle temp = currentVehicle;
        currentVehicle = null;
        return temp;
    }

    public int getNumber() {
        return number;
    }
}
