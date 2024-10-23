package assessment.carRental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Concrete class for VehicleInventory implementing Search functionality
public class VehicleInventory implements Search {
    private HashMap<String, List<Vehicle>> vehicleTypes = new HashMap<>();
    private HashMap<String, List<Vehicle>> vehicleModels = new HashMap<>();

    @Override
    public List<Vehicle> searchByType(String query) {
        System.out.println("Searching vehicles by type: " + query);
        return vehicleTypes.getOrDefault(query, new ArrayList<>());
    }

    @Override
    public List<Vehicle> searchByModel(String query) {
        System.out.println("Searching vehicles by model: " + query);
        return vehicleModels.getOrDefault(query, new ArrayList<>());
    }
}
