import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Drives the ATM session menu: transaction history, withdraw, deposit,
 * transfer, and quit.
 */
public class ATM {
    private Account currentAccount;
    private Bank bank;
    private List<Transaction> transactionHistory = new ArrayList<>();
    private Scanner scanner;

    public ATM(Account currentAccount, Bank bank, Scanner scanner) {
        this.currentAccount = currentAccount;
        this.bank = bank;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    showTransactionHistory();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    transfer();
                    break;
                case "5":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showTransactionHistory() {
        System.out.println("\n----- Transaction History -----");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet in this session.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    private void withdraw() {
        System.out.print("\nEnter amount to withdraw: Rs ");
        double amount = readAmount();
        if (amount <= 0) return;

        if (currentAccount.withdraw(amount)) {
            transactionHistory.add(new Transaction("WITHDRAW", amount, ""));
            System.out.println("Withdrawal successful. New balance: Rs " +
                    String.format("%.2f", currentAccount.getBalance()));
        } else {
            System.out.println("Insufficient Funds.");
        }
    }

    private void deposit() {
        System.out.print("\nEnter amount to deposit: Rs ");
        double amount = readAmount();
        if (amount <= 0) return;

        currentAccount.deposit(amount);
        transactionHistory.add(new Transaction("DEPOSIT", amount, ""));
        System.out.println("Deposit successful. New balance: Rs " +
                String.format("%.2f", currentAccount.getBalance()));
    }

    private void transfer() {
        System.out.print("\nEnter recipient User ID: ");
        String recipientId = scanner.nextLine().trim();
        Account recipient = bank.getAccountByUserId(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }
        if (recipient.getUserId().equals(currentAccount.getUserId())) {
            System.out.println("You cannot transfer to your own account.");
            return;
        }

        System.out.print("Enter amount to transfer: Rs ");
        double amount = readAmount();
        if (amount <= 0) return;

        if (currentAccount.withdraw(amount)) {
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("TRANSFER", amount, "to " + recipientId));
            System.out.println("Transfer successful. New balance: Rs " +
                    String.format("%.2f", currentAccount.getBalance()));
        } else {
            System.out.println("Insufficient Funds.");
        }
    }

    private double readAmount() {
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
                return -1;
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.");
            return -1;
        }
    }
}
