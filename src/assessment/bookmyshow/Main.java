package assessment.bookmyshow;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();
        // Adding Movies
        Movie movie1 = new Movie("Avengers", 180);
        Movie movie2 = new Movie("Inception", 150);
        bookMyShow.addMovie(movie1);
        bookMyShow.addMovie(movie2);

        // Adding Screens
        Screen screen1 = new Screen(1, 100);
        Screen screen2 = new Screen(2, 200);
        bookMyShow.addScreen(screen1);
        bookMyShow.addScreen(screen2);

        // Adding Shows
        Show show1 = new Show(1, movie1, screen1, new Date());
        Show show2 = new Show(2, movie2, screen2, new Date());
        bookMyShow.addShow(show1);
        bookMyShow.addShow(show2);

        // User Booking
        User user = new User("John Doe", "john@example.com");
        boolean bookingSuccess = bookMyShow.bookSeats(user, 1, 2);

        if (bookingSuccess) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed! Not enough seats.");
        }

        // Display available shows for a movie
        System.out.println("Shows for Avengers:");
        List<Show> avengerShows = bookMyShow.getShowsForMovie("Avengers");
        for (Show show : avengerShows) {
            System.out.println("Show ID: " + show.getShowId() + ", Available Seats: " + show.getAvailableSeats());
        }
    }
}