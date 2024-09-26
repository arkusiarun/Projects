package practise.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private Map<String, ParkingSpot> vehicleToSpotMap;

    public ParkingLot(int numSpots) {
        spots = new ArrayList<>();
        vehicleToSpotMap = new HashMap<>();
        for (int i = 0; i < numSpots; i++) {
            VehicleType type = (i % 2 == 0) ? VehicleType.MEDIUM : VehicleType.SMALL;
            spots.add(new ParkingSpot(i, type));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.park(vehicle)) {
                vehicleToSpotMap.put(vehicle.getLicensePlate(), spot);
                return true;
            }
        }
        return false;
    }

    public Vehicle leaveParking(String licensePlate) {
        ParkingSpot spot = vehicleToSpotMap.remove(licensePlate);
        if (spot != null) {
            return spot.leave();
        }
        return null;
    }

    public List<ParkingSpot> getAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }
}
