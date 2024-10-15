package assessment.bidSystem;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public void addUser(int userId, String userName, int superCoin) {
        if(getUser(userId) == null) {
            this.getUserList().add(new User(userId, userName, superCoin));
            System.out.println(userName + " Added SuccessFully");
        }
    }

    public static User getUser(int userId) {
        for(User user: userList) {
            if(user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}