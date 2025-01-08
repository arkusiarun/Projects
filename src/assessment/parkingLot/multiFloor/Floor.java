package assessment.parkingLot.multiFloor;

import java.util.ArrayList;
import java.util.List;

// Represents a floor with parking slots
public class Floor {
    private final int floorId;
    private final List<ParkingSlot> slots;

    public Floor(int floorId, int totalSlots) {
        this.floorId = floorId;
        this.slots = new ArrayList<>();
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    public ParkingSlot findAndParkCar(Car car) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.occupy()) {
                System.out.println("Car " + car.getCarId() + " parked in slot " + slot.getSlotId() + " on floor " + floorId);
                return slot;
            }
        }
        return null; // No available slot on this floor
    }

    public void vacateSlot(ParkingSlot slot, Car car) {
        slot.vacate();
        System.out.println("Car " + car.getCarId() + " left slot " + slot.getSlotId() + " on floor " + floorId);
    }

    public int getFloorId() {
        return floorId;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}
