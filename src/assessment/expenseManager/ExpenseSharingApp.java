package assessment.expenseManager;

import java.util.*;

public class ExpenseSharingApp {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        // Add users
        manager.addUser("U1", "Alice");
        manager.addUser("U2", "Bob");
        manager.addUser("U3", "Charlie");
        manager.addUser("U4", "David");

        // Create a group
        manager.createGroup("G1", "Friends");

        // Add users to the group
        manager.addUserToGroup("G1", "U1");
        manager.addUserToGroup("G1", "U2");
        manager.addUserToGroup("G1", "U3");

        // Add expenses
        manager.addExpense("U1", 150, "G1"); // Alice pays 150 for the group
        manager.addExpense("U2", 90, "G1");  // Bob pays 90 for the group

        // Show expenses
        manager.showExpenses();

        // Show balances
        manager.showBalances();
    }
}