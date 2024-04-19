import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionManager {
    private List<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

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

    public void showIncomeTransactions() {
        transactions.stream()
                .filter(t -> t.getType() == Transaction.TransactionType.INCOME)
                .forEach(System.out::println);
    }

    public void showExpenseTransactions() {
        transactions.stream()
                .filter(t -> t.getType() == Transaction.TransactionType.EXPENSE)
                .forEach(System.out::println);
    }

    public double getTotalBalance() {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
