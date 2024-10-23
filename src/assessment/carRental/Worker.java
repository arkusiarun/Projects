package assessment.carRental;

// Worker class responsible for managing vehicle returns
public class Worker extends Account {
    public boolean updateVehicleLog(Vehicle vehicle, VehicleLog log) {
        vehicle.getLog().add(log);
        System.out.println("Vehicle log updated.");
        return true;
    }
}
