package assessment.bookmyshow;

import java.util.Date;

public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private int availableSeats;

    public Show(int showId, Movie movie, Screen screen, Date startTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.availableSeats = screen.getTotalSeats();
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeats(int seats) {
        if (seats > availableSeats) {
            return false;
        }
        availableSeats -= seats;
        return true;
    }
}
