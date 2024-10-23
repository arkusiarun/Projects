package assessment.carRental;

// Enums representing various statuses in the car rental system

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Concrete class for managing vehicle reservations
public class VehicleReservation {
    private String reservationNumber;
    private Date creationDate;
    private ReservationStatus status;
    private Date dueDate;
    private Date returnDate;
    private String pickupLocationName;
    private String returnLocationName;

    private int customerID;
    private Vehicle vehicle;
    //private Bill bill;
    private List<AdditionalDriver> additionalDrivers = new ArrayList<>();
    //private List<Notification> notifications = new ArrayList<>();
    //private List<RentalInsurance> insurances = new ArrayList<>();
    //private List<Equipment> equipments = new ArrayList<>();
    //private List<Service> services = new ArrayList<>();

    public static VehicleReservation fetchReservationDetails(String reservationNumber) {
        System.out.println("Fetching reservation details for: " + reservationNumber);
        return new VehicleReservation();
    }

    public List<AdditionalDriver> getAdditionalDrivers() {
        return additionalDrivers;
    }

    public boolean completeReservation() {
        this.status = ReservationStatus.COMPLETED;
        System.out.println("Reservation completed.");
        return true;
    }
}