import java.io.Serializable;
import java.util.Date;

class Loan implements Serializable {
    private Reader reader;
    private Book book;
    private String loanDate;
    private String returnDate;

    public Loan(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
        this.loanDate = new Date().toString();
        this.returnDate = "";
        book.setAvailability(false);
    }

    public Book getBook() {

        return book;
    }

    public String getLoanDate() {

        return loanDate;
    }

    public String getReturnDate() {

        return returnDate;
    }

    public void setReturnDate(String returnDate) {

        this.returnDate = returnDate;
    }

}
