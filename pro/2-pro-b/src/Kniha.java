import java.io.Serializable;

class Kniha implements Serializable {
    private String nazev;
    private String autor;
    private int rokVydani;

    private boolean dostupna;

    public Kniha(String nazev, String autor, int rokVydani) {
        this.nazev = nazev;
        this.autor = autor;
        this.rokVydani = rokVydani;
        this.dostupna = true;
    }
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }

    public void setDostupna(boolean dostupna) {
        this.dostupna = dostupna;
    }

    public String getNazev() {
        return nazev;
    }

    public String getAutor() {
        return autor;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public boolean isDostupna() {
        return dostupna;
    }
}
