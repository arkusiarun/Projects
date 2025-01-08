package assessment.parkingLot.multiFloor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Represents the parking lot managing multiple floors
public class ParkingLot {
    private final List<Floor> floors;
    private final Lock lock = new ReentrantLock();

    public ParkingLot(int numFloors, int slotsPerFloor) {
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i, slotsPerFloor));
        }
    }

    public ParkingSlot findAndParkCar(Car car) {
        lock.lock();
        try {
            for (Floor floor : floors) {
                ParkingSlot slot = floor.findAndParkCar(car);
                if (slot != null) {
                    return slot;
                }
            }
            System.out.println("Car " + car.getCarId() + " is waiting for an available slot.");
            return null; // No slot available in the entire parking lot
        } finally {
            lock.unlock();
        }
    }

    public void vacateSlot(ParkingSlot slot, Floor floor, Car car) {
        lock.lock();
        try {
            floor.vacateSlot(slot, car);
        } finally {
            lock.unlock();
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
