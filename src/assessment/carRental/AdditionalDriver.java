package assessment.carRental;

// AdditionalDriver class representing extra drivers for a reservation
public class AdditionalDriver {
    private String driverID;
    private Person person;

    public AdditionalDriver(String driverID, Person person) {
        this.driverID = driverID;
        this.person = person;
    }
}
