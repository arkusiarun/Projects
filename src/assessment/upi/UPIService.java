package assessment.upi;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class UPIService {


    private Map<String, User> users = new HashMap<>();
    private Map<String, Bank> banks = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private Random random = new Random();

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public UPIService() {
        executorService.scheduleAtFixedRate(this::retry, 0, 30, TimeUnit.SECONDS);
    }

    public void registerBank(String bankName, ServerStatus status) {
        banks.put(bankName, new Bank(bankName, status));
    }

    public void registerUser(String name, String phoneNumber) {
        if (users.containsKey(phoneNumber)) {
            throw new IllegalArgumentException("Phone number already exists!");
        }
        users.put(phoneNumber, new User(name, phoneNumber, AccountStatus.ACTIVE));
    }

    public void linkBankAccount(String phoneNumber, String bankName, String accountNumber, double balance, boolean isPrimary) {
        User user = users.get(phoneNumber);
        if (user == null || user.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalArgumentException("User not active or does not exist!");
        }
        Bank bank = banks.get(bankName);
        if (bank == null || bank.getServerStatus() == ServerStatus.DOWN) {
            throw new IllegalArgumentException("Bank not registered or server down!");
        }
        for (BankAccount account : user.getBankAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                throw new IllegalArgumentException("Account already linked!");
            }
        }
        if (isPrimary) {
            user.getBankAccounts().forEach(acc -> acc.setPrimary(false));
        }
        user.getBankAccounts().add(new BankAccount(accountNumber, bank, balance, isPrimary));
    }

    public void makePayment(String fromPhone, String toPhone, double amount) {
        makePayment(fromPhone,toPhone,amount,null);
    }
    public void makePayment(String fromPhone, String toPhone, double amount, String transactionId) {
        User fromUser = users.get(fromPhone);
        User toUser = users.get(toPhone);
        TransactionStatus status = TransactionStatus.SUCCESS;
        if (fromUser == null || toUser == null) {
            throw new IllegalArgumentException("Users not found");
        }
        if (fromUser.getStatus() != AccountStatus.ACTIVE || toUser.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalArgumentException("One or more users inactive");
        }
        BankAccount fromAccount = fromUser.getBankAccounts().stream().filter(BankAccount::isPrimary).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No primary account linked for from User"));

        BankAccount toAccount = toUser.getBankAccounts().stream().filter(BankAccount::isPrimary).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No primary account linked for to User"));

        if(fromAccount.getBank().getServerStatus() != ServerStatus.UP) {
            throw new IllegalArgumentException("From user's bank server is down");
        }

        if(toAccount.getBank().getServerStatus() != ServerStatus.UP) {
            throw new IllegalArgumentException("To user's bank server is down");
        }

        if (fromAccount.getBalance() < amount) {
            status = TransactionStatus.FAILURE;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Payment interrupted");
        }

        if(TransactionStatus.SUCCESS.equals(status)) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
        }

        if(transactionId == null) {
            String newTransactionId = "Txn" + random.nextInt(100000);
            Transaction transaction = new Transaction(newTransactionId, fromPhone, toPhone, amount, status);
            transactions.add(transaction);
        }
        else {
            Transaction transaction = transactions.stream()
                    .filter(t -> t.getTransactionId().equals(transactionId)).findFirst().get();
            transaction.setStatus(status);
        }
    }

    public void retry() {
        List<Transaction> pendingTransactions = transactions.stream()
                        .filter(t -> t.getStatus().equals(TransactionStatus.FAILURE)
                        || t.getStatus().equals(TransactionStatus.PENDING))
                                .collect(Collectors.toUnmodifiableList());

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(Transaction txn : pendingTransactions) {
            System.out.println("Retrying for transaction Id:- " + txn.getTransactionId());
            reconcileTransactions(txn);
            System.out.println(txn.getTransactionId() + " - " + txn.getAmount()+ " - " + txn.getStatus());
        }
    }

    public void reconcileTransactions(Transaction transaction) {
        makePayment(transaction.getFromUser(), transaction.getToUser(), transaction.getAmount(), transaction.getTransactionId());
    }

    public List<Transaction> getUserTransactionHistory(String phoneNumber) {
        return transactions.stream()
                .filter(t -> t.getFromUser().equals(phoneNumber) || t.getToUser().equals(phoneNumber))
                .toList();
    }

    public List<Transaction> getTransactionsByDate(Date start, Date end){
        return transactions.stream()
                .filter(t -> !t.getDate().before(start) && !t.getDate().after(end))
                .collect(Collectors.toList());
    }
}

