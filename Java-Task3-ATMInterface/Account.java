/**
 * Represents a single bank account holder.
 */
public class Account {
    private String accountId;
    private String userId;
    private String pin;
    private double balance;

    public Account(String accountId, String userId, String pin, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Attempts to withdraw the given amount.
     * @return true if the withdrawal succeeded, false if funds were insufficient.
     */
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
