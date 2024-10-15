package assessment.bidSystem;

import java.text.ParseException;

public class Runner {

    public static void main(String[] args) throws ParseException {
        UserService userService = new UserService();
        EventService eventService = new EventService();
        WinnerService winnerService = new WinnerService();

        // ADD_MEMBER
        userService.addUser(1, "Akshay", 10000);
        userService.addUser(2, "Chris", 5000);

        // ADD_EVENT
        eventService.createEvent(1, "BBD", "IPHONE-14", "2023-06-06 ");

        //REGISTER_MEMBER
        eventService.registerMemberToEvent(1, 1);

        //SUBMIT_BID
        eventService.submitBid(1, 1, 100, 200, 400, 500, 600);
        eventService.submitBid(2, 1, 100, 200, 400, 500);
        eventService.submitBid(10, 1, 100, 200, 400, 500);

        //DECLARE_WINNER
        winnerService.decideWinnerForEvent(1);

        //LIST_WINNERS
        for (Winner winner : winnerService.getAllWinners()) {
            System.out.println(winner.getEventId() + ", " + winner.getUserName() + ", " + winner.getLowestBid() + ", " + winner.getWinningDate());
        }
    }
}
