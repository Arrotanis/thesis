import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();

        manager.addTransaction(new Transaction(500, LocalDate.of(2024, 4, 1), "Plat", Transaction.TransactionType.INCOME));
        manager.addTransaction(new Transaction(-150, LocalDate.of(2024, 4, 2), "Jídlo", Transaction.TransactionType.EXPENSE));
        manager.addTransaction(new Transaction(-200, LocalDate.of(2024, 4, 3), "Nájem", Transaction.TransactionType.EXPENSE));
        manager.addTransaction(new Transaction(200, LocalDate.of(2024, 4, 4), "Vrácení dluhu", Transaction.TransactionType.INCOME));

        System.out.println("Všechny transakce:");
        manager.showAllTransactions();

        System.out.println("\nPříjmy:");
        manager.showIncomeTransactions();

        System.out.println("\nVýdaje:");
        manager.showExpenseTransactions();

        System.out.println("\nCelkový zůstatek: " + manager.getTotalBalance());
    }
}
