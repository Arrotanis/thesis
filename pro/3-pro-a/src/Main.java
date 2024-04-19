
public class Main {
    public static void main(String[] args) {
        FinancialSystem system = new FinancialSystem();

        system.addTransaction(50000,  "Mzda");
        system.addTransaction(-5000,  "Plyn");
        system.addTransaction(-300, "Internet");

        system.displayAllTransactions();
        system.displayIncomeTransactions();
        system.displayExpenseTransactions();
        system.displayBalance();
    }
}