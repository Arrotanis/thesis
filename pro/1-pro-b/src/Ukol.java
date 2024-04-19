import java.io.Serializable;
class Ukol implements Serializable {
    private String nazev;
    private String popis;
    private boolean dokoncen = false;

    public Ukol(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setDokoncen(boolean dokoncen) {
        this.dokoncen = dokoncen;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public boolean isDokoncen() {
        return dokoncen;
    }
}