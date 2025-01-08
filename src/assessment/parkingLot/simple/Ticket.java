package assessment.parkingLot.simple;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final String licensePlate;
    private final int spotId;
    private final LocalDateTime entryTime;

    public Ticket(String ticketId, String licensePlate, int spotId) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", spotId=" + spotId +
                ", entryTime=" + entryTime +
                '}';
    }
}