package assessment.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    private List<Movie> movies = new ArrayList<>();
    private List<Screen> screens = new ArrayList<>();
    private List<Show> shows = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Show> getShowsForMovie(String movieName) {
        List<Show> result = new ArrayList<>();
        for (Show show : shows) {
            if (show.getMovie().getName().equalsIgnoreCase(movieName)) {
                result.add(show);
            }
        }
        return result;
    }

    public boolean bookSeats(User user, int showId, int seats) {
        for (Show show : shows) {
            if (show.getShowId() == showId) {
                if (show.bookSeats(seats)) {
                    bookings.add(new Booking(user, show, seats));
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
