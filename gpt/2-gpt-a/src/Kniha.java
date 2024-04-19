import java.io.Serializable;

public class Kniha implements Serializable {
    private String nazev;
    private String autor;
    private int rokVydani;
    private boolean dostupnost;

    public Kniha(String nazev, String autor, int rokVydani) {
        this.nazev = nazev;
        this.autor = autor;
        this.rokVydani = rokVydani;
        this.dostupnost = true; // Knihy jsou výchozí dostupné
    }

    // Gettery a settery
    public String getNazev() {
        return nazev;
    }

    public String getAutor() {
        return autor;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    @Override
    public String toString() {
        return String.format("%s od %s, %d - Dostupnost: %s", nazev, autor, rokVydani, dostupnost ? "Ano" : "Ne");
    }
}
