import java.io.Serializable;
import java.util.Date;

public class Vypujcka implements Serializable {
    private Ctenar ctenar;
    private Kniha kniha;
    private Date datumVypujcky;
    private Date datumVraceni;

    public Vypujcka(Ctenar ctenar, Kniha kniha, Date datumVypujcky) {
        this.ctenar = ctenar;
        this.kniha = kniha;
        this.datumVypujcky = datumVypujcky;
        this.datumVraceni = null; // Datum vrácení se nastaví při vrácení knihy
    }

    // Gettery a settery
    public Ctenar getCtenar() {
        return ctenar;
    }

    public Kniha getKniha() {
        return kniha;
    }

    public Date getDatumVypujcky() {
        return datumVypujcky;
    }

    public Date getDatumVraceni() {
        return datumVraceni;
    }

    public void setDatumVraceni(Date datumVraceni) {
        this.datumVraceni = datumVraceni;
    }

    @Override
    public String toString() {
        return String.format("%s vypůjčil/a %s dne %s", ctenar.getEmail(), kniha.getNazev(), datumVypujcky.toString());
    }
}
