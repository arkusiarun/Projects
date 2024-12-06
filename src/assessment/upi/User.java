package assessment.upi;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    final private String phoneNumber;
    private AccountStatus status;
    private List<BankAccount> bankAccounts;

    public User(String name, String phoneNumber, AccountStatus status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.bankAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}