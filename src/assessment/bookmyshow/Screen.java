package assessment.bookmyshow;

public class Screen {
    private int screenId;
    private int totalSeats;

    public Screen(int screenId, int totalSeats) {
        this.screenId = screenId;
        this.totalSeats = totalSeats;
    }

    public int getScreenId() {
        return screenId;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
