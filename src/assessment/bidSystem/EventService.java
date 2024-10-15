package assessment.bidSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EventService {
    static List<Event> eventList;

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public EventService() {
        this.eventList = new ArrayList<>();
    }

    public void createEvent(int eventId, String eventName, String prizeName, String eventDate) throws ParseException {
        if(getEvent(eventId) == null) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(eventDate);
            this.eventList.add(new Event(eventId, eventName, prizeName, date));
            System.out.println(eventName + " with prize " + prizeName +  " added successfully");
        }
    }

    public static Event getEvent(int eventId) {
        for(Event event: eventList) {
            if(event.getEventId() == eventId) {
                return event;
            }
        }
        return null;
    }

    public void registerMemberToEvent(int userId, int eventId) {
        Event event = getEvent(eventId);
        if (event == null) {
            System.out.println("Event Not Found");
        }
        Map<Integer, List<Bid>> userBids = event.getMembers();
        if (userBids.containsKey(userId)) {
            System.out.println("User Already Registered");
        } else {
            userBids.put(userId, new ArrayList<>());
            System.out.println(UserService.getUser(userId).getUserName() + " registered to the " + getEvent(eventId).getEventName() + " event successfully");
        }
    }

    public void submitBid(int userId, int eventId, int... bidsArr) {
        Event event = getEvent(eventId);
        User user = UserService.getUser(userId);
        if(user == null) {
            System.out.println("User Not Found");
            return;
        }
        List<Bid> bids = event.getMembers().get(userId);
        if (bids == null) {
            System.out.println("Member did not registered for this event");
            return;
        }
        for (int bid : bidsArr) {
            if (bid != 0) {
                event.addBidToEvent(userId, bid);
            }
        }
        System.out.println("BIDS submitted successfully");
    }
}