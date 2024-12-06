package assessment.upi;

import java.util.Date;

public class Transaction {

    final private String transactionId;
    private String fromUser;
    private String toUser;
    private double amount;
    private TransactionStatus status;
    private Date date;

    public Transaction(String transactionId, String fromUser, String toUser, double amount, TransactionStatus status) {
        this.transactionId = transactionId;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.status = status;
        this.date = new Date();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }
}
