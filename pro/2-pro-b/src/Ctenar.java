import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Ctenar implements Serializable {
    private String jmeno;
    private String prijmeni;
    private String email;

    private List<Vypujcka> seznamVypujcek;

    public Ctenar(String jmeno, String prijmeni, String email) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.email = email;
        seznamVypujcek = new ArrayList<>();
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSeznamVypujcek(List<Vypujcka> seznamVypujcek) {
        this.seznamVypujcek = seznamVypujcek;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public List<Vypujcka> getSeznamVypujcek() {
        return seznamVypujcek;
    }
}
