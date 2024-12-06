package assessment.upi;

public class BankAccount {
    private String accountNumber;
    private Bank bank;
    private double balance;
    private boolean isPrimary;

    public BankAccount(String accountNumber, Bank bank, double balance, boolean isPrimary) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = balance;
        this.isPrimary = isPrimary;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}
