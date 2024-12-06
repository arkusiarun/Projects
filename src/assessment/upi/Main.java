package assessment.upi;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UPIService upiService = new UPIService();

        upiService.registerBank("AXIS", ServerStatus.UP);
        upiService.registerBank("HDFC", ServerStatus.UP);
        upiService.registerBank("ICICI", ServerStatus.UP);

        upiService.registerUser("Alice", "1234567890");
        upiService.registerUser("Bob", "0987654321");

        upiService.linkBankAccount("1234567890", "AXIS", "AXIS001", 4000, true);
        upiService.linkBankAccount("1234567890", "HDFC", "HDFC001", 5000, false);
        upiService.linkBankAccount("0987654321", "ICICI", "ICICI001", 3000, true);

        upiService.makePayment("1234567890", "0987654321", 2000);
        upiService.makePayment("1234567890", "0987654321", 4000);

        List<Transaction> aliceTransactions = upiService.getUserTransactionHistory("1234567890");
        System.out.println("Alice Transactions:");
        for (Transaction txn : aliceTransactions) {
            System.out.println(txn.getTransactionId() + " - " + txn.getAmount() + " - " + txn.getStatus());
        }

        Date start = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 60);
        Date end = new Date();

        List<Transaction> transactions = upiService.getTransactionsByDate(start, end);
        System.out.println("Number of Transactions in last 1 hour: ");
        for (Transaction txn : transactions) {
            System.out.println(txn.getTransactionId() + " - " + txn.getAmount() + " - " + txn.getStatus());
        }

        upiService.makePayment("0987654321", "1234567890", 2000);

    }
}