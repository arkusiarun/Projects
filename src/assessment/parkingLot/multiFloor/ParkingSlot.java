package assessment.parkingLot.multiFloor;

// Represents an individual parking slot
public class ParkingSlot {
    private final int slotId;
    private boolean isOccupied;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
    }

    public synchronized boolean occupy() {
        if (!isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }

    public synchronized void vacate() {
        isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getSlotId() {
        return slotId;
    }
}
