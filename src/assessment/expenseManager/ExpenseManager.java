package assessment.expenseManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private final List<Expense> expenses = new ArrayList<>();
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    // Add a user
    public void addUser(String userId, String name) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId, name));
            balances.put(userId, new HashMap<>());
            System.out.println("User added: " + name);
        } else {
            System.out.println("User already exists: " + name);
        }
    }

    // Create a group
    public void createGroup(String groupId, String groupName) {
        if (!groups.containsKey(groupId)) {
            groups.put(groupId, new Group(groupId, groupName));
            System.out.println("Group created: " + groupName);
        } else {
            System.out.println("Group already exists: " + groupName);
        }
    }

    // Add a user to a group
    public void addUserToGroup(String groupId, String userId) {
        if (!groups.containsKey(groupId)) {
            System.out.println("Group not found: " + groupId);
            return;
        }
        if (!users.containsKey(userId)) {
            System.out.println("User not found: " + userId);
            return;
        }
        groups.get(groupId).addMember(userId);
        System.out.println("User " + users.get(userId).getName() + " added to group " + groups.get(groupId).getGroupName());
    }

    // Add an expense
    public void addExpense(String paidBy, double amount, String groupId) {
        if (!groups.containsKey(groupId)) {
            System.out.println("Group not found: " + groupId);
            return;
        }
        if (!users.containsKey(paidBy)) {
            System.out.println("User not found: " + paidBy);
            return;
        }

        Group group = groups.get(groupId);
        List<String> sharedWith = new ArrayList<>(group.getMembers());

        // Create an Expense object
        Expense expense = new Expense(paidBy, amount, groupId, sharedWith);
        expenses.add(expense);

        double splitAmount = amount / sharedWith.size();

        for (String userId : sharedWith) {
            if (!userId.equals(paidBy)) {
                // Update balances
                balances.get(paidBy).put(userId, balances.get(paidBy).getOrDefault(userId, 0.0) + splitAmount);
                balances.get(userId).put(paidBy, balances.get(userId).getOrDefault(paidBy, 0.0) - splitAmount);
            }
        }
        System.out.println("Expense of " + amount + " added to group " + group.getGroupName() + " paid by " + users.get(paidBy).getName());
    }

    // Show balances
    public void showBalances() {
        boolean isBalanced = true;

        for (String userId : balances.keySet()) {
            for (Map.Entry<String, Double> balance : balances.get(userId).entrySet()) {
                if (balance.getValue() > 0) {
                    isBalanced = false;
                    System.out.printf("%s owes %s: %.2f%n",
                            users.get(userId).getName(),
                            users.get(balance.getKey()).getName(),
                            balance.getValue());
                }
            }
        }

        if (isBalanced) {
            System.out.println("All balances are settled!");
        }
    }

    // Show all expenses
    public void showExpenses() {
        System.out.println("\nExpenses:");
        for (Expense expense : expenses) {
            System.out.printf("Paid by %s, Amount: %.2f, Group: %s, Shared with: %s%n",
                    users.get(expense.getPaidBy()).getName(),
                    expense.getAmount(),
                    groups.get(expense.getGroupId()).getGroupName(),
                    getUserNames(expense.getSharedWith()));
        }
    }

    private String getUserNames(List<String> userIds) {
        List<String> names = new ArrayList<>();
        for (String userId : userIds) {
            names.add(users.get(userId).getName());
        }
        return String.join(", ", names);
    }
}
