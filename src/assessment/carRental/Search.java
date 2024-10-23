package assessment.carRental;

import java.util.List;

// Interface for search functionality
public interface Search {
    public List<Vehicle> searchByType(String type);

    public List<Vehicle> searchByModel(String model);
}
