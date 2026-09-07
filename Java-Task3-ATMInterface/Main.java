import java.util.Scanner;

/**
 * OIBSIP - Java Development Track
 * Task 3: ATM Interface
 *
 * Entry point: authenticates the user (denying access after 3 failed
 * attempts) then hands off to the ATM menu.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=========================================");
        System.out.println("            WELCOME TO JAVA ATM");
        System.out.println("=========================================");
        System.out.println("(Demo accounts: user1/1234  or  user2/5678)");

        int attempts = 0;
        Account authenticatedAccount = null;

        while (attempts < 3 && authenticatedAccount == null) {
            System.out.print("\nEnter User ID: ");
            String userId = scanner.nextLine().trim();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine().trim();

            authenticatedAccount = bank.authenticate(userId, pin);

            if (authenticatedAccount == null) {
                attempts++;
                System.out.println("Invalid credentials. Attempts remaining: " + (3 - attempts));
            }
        }

        if (authenticatedAccount == null) {
            System.out.println("\nToo many failed attempts. Access denied.");
            scanner.close();
            return;
        }

        System.out.println("\nLogin successful. Welcome, " + authenticatedAccount.getUserId() + "!");
        ATM atm = new ATM(authenticatedAccount, bank, scanner);
        atm.showMenu();

        scanner.close();
    }
}
