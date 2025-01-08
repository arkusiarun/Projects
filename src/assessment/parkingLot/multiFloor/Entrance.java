package assessment.parkingLot.multiFloor;

public class Entrance implements Runnable {
    private final ParkingLot parkingLot;
    private final int entranceId;

    public Entrance(ParkingLot parkingLot, int entranceId) {
        this.parkingLot = parkingLot;
        this.entranceId = entranceId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // Simulate 5 cars arriving at this entrance
            int carId = entranceId * 10 + i;
            Car car = new Car(carId);
            ParkingSlot slot = parkingLot.findAndParkCar(car);

            if (slot != null) {
                try {
                    Thread.sleep(2000); // Simulate parking duration
                    Floor floor = parkingLot.getFloors().get((slot.getSlotId() - 1) / parkingLot.getFloors().get(0).getSlots().size());
                    parkingLot.vacateSlot(slot, floor, car);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                try {
                    Thread.sleep(1000); // Wait and retry if no slot is available
                    i--; // Retry parking for the same car
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}