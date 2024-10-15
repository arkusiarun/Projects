package assessment.bidSystem;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {

    static List<Winner> winners;

    public WinnerService() {
        this.winners = new ArrayList<>();
    }

    public Winner getWinner(int eventId) {
        for (Winner winner : winners) {
            if (winner.getEventId() == eventId) {
                return winner;
            }
        }
        return null;
    }

    public void decideWinnerForEvent(int eventId) {
        Event event = EventService.getEvent(eventId);
        event.setEventStatus(EventStatus.CLOSED);
        Bid lowestBid = event.getLowestBid();
        Winner winner = new Winner(event.getEventId(),
                UserService.getUser(lowestBid.getUserId()).getUserName(),
                event.getPrizeName(),
                lowestBid.getBidAmount(), event.getEventDate());
        winners.add(winner);
        System.out.println(winner.getUserName() + " wins the " + winner.getPrizeName() + " with lowest bid " + lowestBid.getBidAmount());
    }

    public List<Winner> getAllWinners() {
        return winners;
    }
}
