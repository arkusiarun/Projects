package assessment.bidSystem;

import java.util.*;

public class Event {

    int eventId;
    String eventName;
    String prizeName;
    Date eventDate;
    Map<Integer, List<Bid>> members;
    int maxBidPerUser;
    EventStatus eventStatus;
    Bid lowestBid;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Map<Integer, List<Bid>> getMembers() {
        return members;
    }

    public void setMembers(Map<Integer, List<Bid>> members) {
        this.members = members;
    }

    public int getMaxBidPerUser() {
        return maxBidPerUser;
    }

    public void setMaxBidPerUser(int maxBidPerUser) {
        this.maxBidPerUser = maxBidPerUser;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Bid getLowestBid() {
        return lowestBid;
    }

    public void setLowestBid(Bid lowestBid) {
        this.lowestBid = lowestBid;
    }

    public Event(int eventId, String eventName, String prizeName, Date eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.members = new HashMap<>();
        this.maxBidPerUser = 5;
        this.prizeName = prizeName;
        this.eventDate = eventDate;
        this.eventStatus = EventStatus.OPEN;
        this.lowestBid = null;
    }

    public void addBidToEvent(int userId, int bidAmount) {
        if (!EventStatus.OPEN.equals(this.getEventStatus())) {
            System.out.println("EVENT Closed or Not Found");
            return;
        }
        if (this.lowestBid==null || lowestBid.getBidAmount() > bidAmount) {
            this.lowestBid = new Bid(userId, bidAmount);
        }
        List<Bid> bidList = new ArrayList<>();
        if (members.containsKey(userId)) {
            bidList = members.get(userId);
            if (bidList.size() < this.maxBidPerUser && !bidList.contains(new Bid(userId, bidAmount))) {
                bidList.add(new Bid(userId, bidAmount));
            } else {
                System.out.println("Cannot Place Bid");
            }
        } else {
            bidList.add(new Bid(userId, bidAmount));
            members.put(userId, bidList);
        }
    }
}
