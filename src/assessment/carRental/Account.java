package assessment.carRental;

// Abstract Account class to manage user account details
public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword() {
        System.out.println("Password reset for account: " + id);
        return true;
    }
}
