import java.util.Date;

class Transaction {
    private double amount;
    private String date;
    private String description;
    private String type;

    public Transaction(double value, String description) {
        this.amount = value;
        this.date = new Date().toString();
        this.description = description;
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
}
