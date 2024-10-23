package assessment.carRental;

public class ReserveVehicleCommand implements Command {
    private VehicleReservation reservation;

    public ReserveVehicleCommand(VehicleReservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public void execute() {
        reservation.completeReservation();
    }
}
