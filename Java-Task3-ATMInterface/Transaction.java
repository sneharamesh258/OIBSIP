import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single logged transaction (deposit, withdrawal, or transfer).
 */
public class Transaction {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private String type;
    private double amount;
    private String detail;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount, String detail) {
        this.type = type;
        this.amount = amount;
        this.detail = detail;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String base = "[" + timestamp.format(FORMATTER) + "] " + type +
                " : Rs " + String.format("%.2f", amount);
        return detail.isEmpty() ? base : base + " (" + detail + ")";
    }
}
