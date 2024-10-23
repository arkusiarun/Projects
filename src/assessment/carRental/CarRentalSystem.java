package assessment.carRental;

import java.util.ArrayList;
import java.util.List;

// CarRentalSystem class to manage the entire rental system
public class CarRentalSystem {
    private String name;
    private List<CarRentalLocation> locations = new ArrayList<>();

    public boolean addNewLocation(CarRentalLocation location) {
        locations.add(location);
        System.out.println("New location added: " + location.getLocation());
        return true;
    }
}
