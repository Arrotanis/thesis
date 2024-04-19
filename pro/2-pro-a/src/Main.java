

public class Main {
    public static void main(String[] args) {
        Library library = Library.loadFromFile("soubor.ser");
        if (library != null) {
            System.out.println("Načtená knihovna:");
            library.showAvailableBooks();
        }
        else {
            library = new Library();
        }

        library.addBook(new Book("Hobbit", "J.R.R. Tolkien", 1980));
        library.addBook(new Book("Dune", "Frank Herbert", 1960));
        library.addBook(new Book("Harry Potter", "J.K. Rowling", 2020));

        library.showAvailableBooks();

        library.addReader(new Reader("Jakub", "Novotny", "novo@seznam.cz"));
        library.createLoan("novo@seznam.cz", "Dune");
        library.showAvailableBooks();


        library.showLoanHistory("novo@seznam.cz");
        library.returnBook("Dune", "novo@seznam.cz");
        library.showAvailableBooks();

        library.saveToFile("soubor.ser");
    }
}
