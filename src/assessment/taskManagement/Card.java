package assessment.taskManagement;

public class Card {

    private String cardId;
    private String name;
    private Priority priority;

    private User userAssigned;


    public Card(String cardId, String name, Priority priority) {
        this.cardId = cardId;
        this.name = name;
        this.priority = priority;
        this.userAssigned = null;
        System.out.println("Card :" + name + " created with Id: " + cardId);
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setUserAssigned(User userAssigned) {
        this.userAssigned = userAssigned;
    }

    public User getUserAssigned() {
        return userAssigned;
    }

    public void userAssigned(User userAssigned) {
        this.userAssigned = userAssigned;
        System.out.println(userAssigned.getName() + " assigned to Card: " + this.name);
    }

    public void userUnassigned() {
        this.userAssigned = null;
    }

    @Override
    public String toString() {
        return "Card:- {" +
                "cardId='" + cardId + '\'' +
                "name='" + name + '\'' +
                ", Priority=" + priority +
                ", User Assigned=" + (userAssigned != null ? userAssigned.getName() : "Unassigned") +
                '}';
    }
}
