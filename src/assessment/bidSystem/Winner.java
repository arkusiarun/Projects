package assessment.bidSystem;

import java.util.Date;

public class Winner {

    int eventId;
    String userName;
    String prizeName;
    int lowestBid;
    Date winningDate;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLowestBid() {
        return lowestBid;
    }

    public void setLowestBid(int lowestBid) {
        this.lowestBid = lowestBid;
    }

    public Date getWinningDate() {
        return winningDate;
    }

    public void setWinningDate(Date winningDate) {
        this.winningDate = winningDate;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Winner(int eventId, String userName, String prizeName, int lowestBid, Date winningDate) {
        this.eventId = eventId;
        this.userName = userName;
        this.prizeName = prizeName;
        this.lowestBid = lowestBid;
        this.winningDate = winningDate;
    }
}
