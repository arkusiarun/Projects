package assessment.expenseManager;

import java.util.List;

public class Expense {
    private final String paidBy;
    private final double amount;
    private final String groupId;
    private final List<String> sharedWith;

    public Expense(String paidBy, double amount, String groupId, List<String> sharedWith) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.groupId = groupId;
        this.sharedWith = sharedWith;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<String> getSharedWith() {
        return sharedWith;
    }
}
