import java.util.HashMap;
import java.util.Map;

/**
 * Holds all accounts and handles authentication/lookup.
 */
public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public Bank() {
        // Preloaded demo accounts for testing: userId / PIN / starting balance
        addAccount(new Account("ACC1001", "user1", "1234", 5000.00));
        addAccount(new Account("ACC1002", "user2", "5678", 10000.00));
    }

    public void addAccount(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public Account authenticate(String userId, String pin) {
        Account account = accounts.get(userId);
        if (account != null && account.validatePin(pin)) {
            return account;
        }
        return null;
    }

    public Account getAccountByUserId(String userId) {
        return accounts.get(userId);
    }
}
