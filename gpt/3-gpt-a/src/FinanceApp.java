import java.util.ArrayList;
import java.util.List;

class Transaction {
    enum Type {
        INCOME, EXPENSE
    }

    private Type type;
    private double amount;
    private String date;
    private String description;

    public Transaction(Type type, double amount, String date, String description) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", Date: " + date + ", Description: " + description;
    }
}

class FinanceManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
        }
    }

    public void showAllTransactions() {
        transactions.forEach(System.out::println);
    }

    public void showTransactionsByType(Transaction.Type type) {
        transactions.stream()
                .filter(t -> t.getType() == type)
                .forEach(System.out::println);
    }

    public void showBalance() {
        double balance = transactions.stream()
                .mapToDouble(t -> t.getType() == Transaction.Type.INCOME ? t.getAmount() : -t.getAmount())
                .sum();
        System.out.println("Total Balance: " + balance);
    }
}

public class FinanceApp {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();

        manager.addTransaction(new Transaction(Transaction.Type.INCOME, 500.00, "2023-04-01", "Salary"));
        manager.addTransaction(new Transaction(Transaction.Type.EXPENSE, 50.00, "2023-04-02", "Groceries"));
        manager.addTransaction(new Transaction(Transaction.Type.EXPENSE, 200.00, "2023-04-03", "Utilities"));
        manager.addTransaction(new Transaction(Transaction.Type.INCOME, 150.00, "2023-04-04", "Freelancing"));

        System.out.println("All Transactions:");
        manager.showAllTransactions();

        System.out.println("\nIncome Transactions:");
        manager.showTransactionsByType(Transaction.Type.INCOME);

        System.out.println("\nExpense Transactions:");
        manager.showTransactionsByType(Transaction.Type.EXPENSE);

        System.out.println("\nTotal Balance:");
        manager.showBalance();
    }
}
