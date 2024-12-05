package assessment.bookmyshow;

public class Booking {
    private User user;
    private Show show;
    private int bookedSeats;

    public Booking(User user, Show show, int bookedSeats) {
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }
}
