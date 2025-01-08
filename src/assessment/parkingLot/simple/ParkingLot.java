package assessment.parkingLot.simple;

import java.util.*;

public class ParkingLot {
    private final List<ParkingSpot> spots;
    private final Map<String, ParkingSpot> vehicleToSpotMap;
    private final Map<String, Ticket> activeTickets;

    public ParkingLot(Map<String, Integer> spotConfig) {
        spots = new ArrayList<>();
        vehicleToSpotMap = new HashMap<>();
        activeTickets = new HashMap<>();

        int spotId = 1;
        for (Map.Entry<String, Integer> entry : spotConfig.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                spots.add(new ParkingSpot(spotId++, type));
            }
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                spot.parkVehicle(vehicle);
                vehicleToSpotMap.put(vehicle.getLicensePlate(), spot);

                // Generate a ticket
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle.getLicensePlate(), spot.getSpotId());
                activeTickets.put(ticketId, ticket);

                System.out.println("Vehicle parked. Ticket issued: " + ticket);
                return ticket;
            }
        }
        System.out.println("No available spot for vehicle type: " + vehicle.getType());
        return null;
    }

    public boolean removeVehicle(String licensePlate) {
        ParkingSpot spot = vehicleToSpotMap.get(licensePlate);
        if (spot != null) {
            spot.removeVehicle();
            vehicleToSpotMap.remove(licensePlate);

            // Remove the corresponding ticket
            activeTickets.values().removeIf(ticket -> ticket.getLicensePlate().equals(licensePlate));
            System.out.println("Vehicle with license plate " + licensePlate + " removed.");
            return true;
        }
        System.out.println("Vehicle with license plate " + licensePlate + " not found.");
        return false;
    }

    public void displayAvailableSpots() {
        System.out.println("Available parking spots:");
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                System.out.println("Spot ID: " + spot.getSpotId() + " | Type: " + spot.getSpotType());
            }
        }
    }
}