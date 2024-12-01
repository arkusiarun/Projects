package assessment.parkingLot;

class ParkingSpot {
    private final int spotId;
    private final String spotType; // Type of vehicle the spot supports
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return spotType.equals(vehicle.getType());
    }

    public void parkVehicle(Vehicle vehicle) {
        if (canFitVehicle(vehicle) && !isOccupied) {
            parkedVehicle = vehicle;
            isOccupied = true;
        } else {
            throw new IllegalStateException("Cannot park vehicle in this spot!");
        }
    }

    public void removeVehicle() {
        parkedVehicle = null;
        isOccupied = false;
    }

    public int getSpotId() {
        return spotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public String getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }
}
