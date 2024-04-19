import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Library implements Serializable {
    private List<Book> bookList;
    private List<Reader> readerList;

    public Library() {
        this.bookList = new ArrayList<>();
        this.readerList = new ArrayList<>();
    }

    public Reader searchByEmail(String email) {
        for (Reader reader : readerList
        ) {
            if (reader.getEmail().equals(email)) {
                return reader;
            }
        }
        return null;
    }

    public Book searchByName(String name, boolean availability) {
        for (Book book : bookList
        ) {
            if (book.getName().equals(name) && book.isAvailable() == availability) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(String name, boolean availability) {
        Book book = searchByName(name, availability);
        bookList.remove(book);
    }

    public void addReader(Reader reader) {
        readerList.add(reader);
    }

    public void removeReader(String email) {
        Reader reader = searchByEmail(email);
        readerList.remove(reader);
    }

    public void createLoan(String email, String bookName) {
        Reader reader = searchByEmail(email);
        Book book = searchByName(bookName, true);
        if (book != null && reader != null) {
            Loan loan = new Loan(reader, book);
            reader.getLoanList().add(loan);
        } else {
            System.out.println("Chyba při vytvoření výpůjčky");
        }
    }

    public void returnBook(String name, String email) {
        Book book = searchByName(name, false);
        Reader reader = searchByEmail(email);
        if (book != null && reader != null) {
            for (Loan loan : reader.getLoanList()
            ) {
                if (book == loan.getBook()) {
                    loan.setReturnDate(new Date().toString());
                    book.setAvailability(true);
                }
            }
        }
    }

    public void showLoanHistory(String email) {
        Reader reader = searchByEmail(email);
        System.out.println("Vypujčky čtenaře: " + reader.getName() + " " + reader.getLastName());
        for (Loan loan : reader.getLoanList()) {
            System.out.println(loan.getBook() + ", Vypůjčeno: " + loan.getLoanDate() + ", Vráceno:  " + loan.getReturnDate());
        }
    }

    public void showAvailableBooks() {
        System.out.println("Dostupné knihy:");
        for (Book book : bookList) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void saveToFile(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Uloženo");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Library loadFromFile(String fileName) {
        Library library = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            library = (Library) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Soubor neexistuje");
        }
        return library;
    }
}
