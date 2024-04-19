import java.io.Serializable;
import java.util.Date;

class Vypujcka implements Serializable {
    private Ctenar ctenar;
    private Kniha kniha;
    private String datumVypujcky;
    private String datumVraceni;

    public Vypujcka(Ctenar ctenar, Kniha kniha) {
        this.ctenar = ctenar;
        this.kniha = kniha;
        this.datumVypujcky = new Date().toString();
        this.datumVraceni = "";
    }

    public void setCtenar(Ctenar ctenar) {
        this.ctenar = ctenar;
    }

    public void setKniha(Kniha kniha) {
        this.kniha = kniha;
    }

    public void setDatumVypujcky(String datumVypujcky) {
        this.datumVypujcky = datumVypujcky;
    }

    public void setDatumVraceni(String datumVraceni) {
        this.datumVraceni = datumVraceni;
    }

    public Ctenar getCtenar() {
        return ctenar;
    }

    public Kniha getKniha() {
        return kniha;
    }

    public String getDatumVypujcky() {
        return datumVypujcky;
    }

    public String getDatumVraceni() {
        return datumVraceni;
    }
}
