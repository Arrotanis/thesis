import java.util.ArrayList;

class FinancialSystem {
    private ArrayList<Transaction> transactions;

    public FinancialSystem() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(double value, String description) {
        Transaction transaction = new Transaction(value, description);
        transactions.add(transaction);
    }

    public void removeTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
        } else {
            System.out.println("Chyba indexu");
        }
    }

    public void displayAllTransactions() {
        System.out.println("Všechny transakce:");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            System.out.println("[" + i + "] " + transaction.getDate() + " " + +
                    transaction.getAmount() + " " + transaction.getDescription());
        }
    }

    public void displayIncomeTransactions() {
        System.out.println("Příjmy:");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction.getDate() + " " + transaction.getAmount() + " " + transaction.getDescription());
            }
        }
    }

    public void displayExpenseTransactions() {
        System.out.println("Výdaje:");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction.getDate() + "  " + transaction.getAmount() + " " + transaction.getDescription());
            }
        }
    }

    public void displayBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        System.out.println("Celkový zůstatek: " + balance);
    }
}
