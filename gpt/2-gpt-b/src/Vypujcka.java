import java.util.Date;
import java.io.Serializable;

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
        return "Vypujcka{" +
                "ctenar=" + ctenar +
                ", kniha=" + kniha +
                ", datumVypujcky=" + datumVypujcky +
                ", datumVraceni=" + (datumVraceni != null ? datumVraceni : "kniha nebyla vrácena") +
                '}';
    }
}
