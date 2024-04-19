import java.io.Serializable;

public class Ukol implements Serializable {
    private String nazev;
    private String popis;
    private boolean splneny;

    public Ukol(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.splneny = false;
    }

    // Gettery a settery
    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public boolean isSplneny() {
        return splneny;
    }

    public void setSplneny(boolean splneny) {
        this.splneny = splneny;
    }

    @Override
    public String toString() {
        return "Ukol{" +
                "nazev='" + nazev + '\'' +
                ", popis='" + popis + '\'' +
                ", splneny=" + splneny +
                '}';
    }
}
