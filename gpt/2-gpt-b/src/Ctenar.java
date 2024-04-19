import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Ctenar implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jmeno;
    private String prijmeni;
    private String email;
    private List<Vypujcka> vypujcky;

    public Ctenar(String jmeno, String prijmeni, String email) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.email = email;
        this.vypujcky = new ArrayList<>();
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

    public List<Vypujcka> getVypujcky() {
        return vypujcky;
    }

    public void addVypujcka(Vypujcka vypujcka) {
        vypujcky.add(vypujcka);
    }

    @Override
    public String toString() {
        return "Ctenar{" +
                "jmeno='" + jmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
