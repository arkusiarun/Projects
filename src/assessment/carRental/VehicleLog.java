package assessment.carRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// VehicleLog class to manage logs for a vehicle
public class VehicleLog {
    private String id;
    private VehicleLogType type;
    private String description;
    private Date creationDate;

    public boolean update() {
        System.out.println("Vehicle log updated.");
        return true;
    }

    public List<VehicleLogType> searchByLogType(VehicleLogType type) {
        return new ArrayList<>();
    }
}
