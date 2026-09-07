# OIBSIP - Java Development Track
## Task 3 · ATM Interface

### Objective
A console-based simulation of an ATM machine. Users authenticate with a
User ID and PIN, then perform standard banking transactions: check
transaction history, withdraw, deposit, and transfer funds.

### Tech Stack
Java (console application), Object-Oriented design with 5 classes:
`Main`, `ATM`, `Account`, `Transaction`, `Bank`

### Class Overview
| Class | Responsibility |
|---|---|
| `Main` | Entry point — handles login (max 3 attempts) and starts the ATM session |
| `ATM` | Drives the menu loop and transaction operations |
| `Account` | Stores account details, balance, deposit/withdraw logic, PIN check |
| `Transaction` | Represents one logged transaction with a timestamp |
| `Bank` | Stores all accounts, handles authentication and lookup |

### How to Run
```bash
javac Main.java ATM.java Account.java Transaction.java Bank.java
java Main
```

### Demo Accounts (preloaded for testing)
| User ID | PIN | Starting Balance |
|---|---|---|
| user1 | 1234 | Rs 5000.00 |
| user2 | 5678 | Rs 10000.00 |

### Features
- Startup prompt for User ID + PIN; access denied after 3 incorrect attempts
- Main menu: Transaction History, Withdraw, Deposit, Transfer, Quit
- Balance check before withdrawal/transfer — shows "Insufficient Funds" if too low
- All transactions logged in an `ArrayList<Transaction>` with timestamps and
  shown clearly under Transaction History
- Transfer validates the recipient User ID exists and isn't the same account
- Input validation on all numeric entries

### Sample Run
```
Enter User ID: user1
Enter PIN: 1234

Login successful. Welcome, user1!

===== MAIN MENU =====
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option: 2

Enter amount to withdraw: Rs 1000
Withdrawal successful. New balance: Rs 4000.00
```

### Author
Sneha R — OIBSIP Java Development Track
