package assessment.carRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Receptionist class responsible for vehicle and worker management
public class Receptionist extends Account {
    private Date dateJoined;

    public List<Member> searchMember(String name) {
        System.out.println("Searching for member: " + name);
        return new ArrayList<>();
    }

    public boolean reserveVehicle(VehicleReservation reservation) {
        System.out.println("Vehicle reserved by receptionist.");
        return true;
    }
}
