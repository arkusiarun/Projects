package assessment.parkingLot;

public class Runner {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle car = new Vehicle("ABC123", VehicleType.MEDIUM);
        Vehicle motorcycle = new Vehicle("XYZ789", VehicleType.SMALL);

        System.out.println("Parking car: " + parkingLot.parkVehicle(car));
        System.out.println("Parking motorcycle: " + parkingLot.parkVehicle(motorcycle));

        System.out.println("Available spots: " + parkingLot.getAvailableSpots().size());

        parkingLot.leaveParking("ABC123");
        System.out.println("Available spots after leaving car: " + parkingLot.getAvailableSpots().size());
    }
}
