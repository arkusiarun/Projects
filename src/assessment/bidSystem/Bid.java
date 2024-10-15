package assessment.bidSystem;

public class Bid {

    int userId;

    int bidAmount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public Bid(int userId, int bidAmount) {
        this.userId = userId;
        this.bidAmount = bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.bidAmount == ((Bid)obj).getBidAmount()) && (this.userId == ((Bid)obj).getBidAmount());
    }
}
