import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ctenar implements Serializable {
    private String jmeno;
    private String prijmeni;
    private String email;
    private List<Vypujcka> seznamVypujcek;

    public Ctenar(String jmeno, String prijmeni, String email) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.email = email;
        this.seznamVypujcek = new ArrayList<>();
    }

    // Gettery a settery
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

    public void pridatVypujcku(Vypujcka vypujcka) {
        seznamVypujcek.add(vypujcka);
    }

    public void odebratVypujcku(Vypujcka vypujcka) {
        seznamVypujcek.remove(vypujcka);
    }

    @Override
    public String toString() {
        return String.format("%s %s, Email: %s", jmeno, prijmeni, email);
    }
}
