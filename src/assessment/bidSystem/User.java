package assessment.bidSystem;

public class User {

    int userId;

    String userName;

    int superCoins;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }

    public User(int userId, String userName, int superCoins) {
        this.userId = userId;
        this.userName = userName;
        this.superCoins = superCoins;
    }
}
