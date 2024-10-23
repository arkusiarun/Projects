package assessment.carRental;

// Main class to demonstrate the implementation of various patterns
public class Main {
    public static void main(String[] args) {
        // Create the system notifier and add customers as observers
        SystemNotifier notifier = new SystemNotifier();
        Customer alice = new Customer("Alice", new Member());
        Customer bob = new Customer("Bob", new Member());
        notifier.addObserver(alice);
        notifier.addObserver(bob);

        // Notify customers about overdue vehicle reservation
        notifier.notifyObservers("Your vehicle reservation is overdue!");

        // Create and complete a vehicle reservation using the Command pattern
        VehicleReservation reservation = new VehicleReservation();
        Command reserveCommand = new ReserveVehicleCommand(reservation);
        reserveCommand.execute();

        // Perform a search for vehicles by type
        VehicleInventory inventory = new VehicleInventory();
        inventory.searchByType("SUV");
    }
}
