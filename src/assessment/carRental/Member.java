package assessment.carRental;

import java.util.ArrayList;
import java.util.List;

// Concrete class for Members who can reserve vehicles
public class Member extends Account {
    private int totalVehiclesReserved;

    public List<VehicleReservation> getReservations() {
        return new ArrayList<>();
    }
}
