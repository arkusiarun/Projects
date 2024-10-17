import java.util.*;

// Enum for Card Priority
enum Priority {
    PO, P1, P2 // PO is the highest, P2 is the lowest
}

// User Class
class User {
    private String userId;
    private String name;
    private String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

// Card Class
class Card {
    private String cardId;
    private String name;
    private Priority priority;
    private User assignedUser;

    public Card(String cardId, String name, Priority priority) {
        this.cardId = cardId;
        this.name = name;
        this.priority = priority;
        this.assignedUser = null; // Unassigned by default
    }

    public void assignUser(User user) {
        this.assignedUser = user;
    }

    public void unassignUser() {
        this.assignedUser = null;
    }

    @Override
    public String toString() {
        return "Card: " + name + ", Priority: " + priority + ", Assigned User: " +
                (assignedUser != null ? assignedUser.getName() : "Unassigned");
    }
}

// List Class (within a Board)
class List {
    private String listId;
    private String name;
    private List<Card> cards;

    public List(String listId, String name) {
        this.listId = listId;
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(String cardId) {
        cards.removeIf(card -> cardId.equals(card.cardId));
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "List: " + name + ", Cards: " + cards.size();
    }
}

// Board Class (for Teams/Projects)
class Board {
    private String boardId;
    private String name;
    private boolean isPrivate;
    private List<User> teamMembers;
    private List<List> lists;

    public Board(String boardId, String name, boolean isPrivate) {
        this.boardId = boardId;
        this.name = name;
        this.isPrivate = isPrivate;
        this.teamMembers = new ArrayList<>();
        this.lists = new ArrayList<>();
    }

    public void addTeamMember(User user) {
        teamMembers.add(user);
    }

    public void removeTeamMember(String userId) {
        teamMembers.removeIf(user -> user.getUserId().equals(userId));
    }

    public void addList(List list) {
        lists.add(list);
    }

    public void removeList(String listId) {
        lists.removeIf(list -> listId.equals(list.listId));
    }

    public List<List> getLists() {
        return lists;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return "Board: " + name + " (Private: " + isPrivate + "), Members: " + teamMembers.size() + ", Lists: " + lists.size();
    }
}

// TaskManager Class to manage all operations
class TaskManager {
    private Map<String, Board> boards;
    
    public TaskManager() {
        this.boards = new HashMap<>();
    }

    public void createBoard(String boardId, String name, boolean isPrivate) {
        Board board = new Board(boardId, name, isPrivate);
        boards.put(boardId, board);
    }

    public void deleteBoard(String boardId) {
        boards.remove(boardId);
    }

    public Board getBoard(String boardId) {
        return boards.get(boardId);
    }

    public void printAllBoards() {
        for (Board board : boards.values()) {
            System.out.println(board);
        }
    }
}

// Main Class for Testing
public class TaskManagementApp {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Create users
        User user1 = new User("1", "Alice", "alice@example.com");
        User user2 = new User("2", "Bob", "bob@example.com");

        // Create a board
        manager.createBoard("101", "Team Alpha", true);
        Board teamAlpha = manager.getBoard("101");

        // Add team members
        teamAlpha.addTeamMember(user1);
        teamAlpha.addTeamMember(user2);

        // Create lists in the board
        List list1 = new List("201", "Project A");
        List list2 = new List("202", "Project B");
        teamAlpha.addList(list1);
        teamAlpha.addList(list2);

        // Create cards in lists
        Card card1 = new Card("301", "Design Database", Priority.PO);
        Card card2 = new Card("302", "Implement API", Priority.P1);

        list1.addCard(card1);
        list1.addCard(card2);

        // Assign user to card1
        card1.assignUser(user1);

        // Print all boards and lists
        manager.printAllBoards();

        // Print cards in list1
        System.out.println("\nCards in List: " + list1.getCards());

        // Remove a card
        list1.removeCard("301");

        // Print cards in list1 after removal
        System.out.println("\nCards in List after removal: " + list1.getCards());

        // Remove a team member
        teamAlpha.removeTeamMember("1");

        // Print all boards and lists after modifications
        manager.printAllBoards();
    }
}
