import java.io.Serializable;

class Book implements Serializable {
    private String name;
    private String author;
    private int year;

    private boolean availability;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.availability = true;
    }

    public String getName() {

        return name;
    }

    public void setAvailability(boolean availability) {

        this.availability = availability;
    }

    public boolean isAvailable() {

        return availability;
    }

    @Override
    public String toString() {
        return
                "Název: " + name +
                        ", Autor: " + author +
                        ", Rok Vydání: " + year +
                        ", Dostupnost: " + availability;
    }
}
