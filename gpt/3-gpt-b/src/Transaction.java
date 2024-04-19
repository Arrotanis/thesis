import java.time.LocalDate;

public class Transaction {
    private double amount;
    private LocalDate date;
    private String description;
    private TransactionType type;

    public Transaction(double amount, LocalDate date, String description, TransactionType type) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Datum: " + date + ", Typ: " + type + ", Částka: " + amount + ", Popis: " + description;
    }

    public enum TransactionType {
        INCOME, EXPENSE
    }
}
