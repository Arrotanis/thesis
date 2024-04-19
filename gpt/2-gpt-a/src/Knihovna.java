import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Knihovna {
    private List<Kniha> seznamKnih;
    private List<Ctenar> seznamCtenaru;

    public Knihovna() {
        this.seznamKnih = new ArrayList<>();
        this.seznamCtenaru = new ArrayList<>();
    }

    public void pridatKnihu(Kniha kniha) {
        seznamKnih.add(kniha);
    }

    public void odebratKnihu(Kniha kniha) {
        seznamKnih.remove(kniha);
    }

    public void pridatCtenare(Ctenar ctenar) {
        seznamCtenaru.add(ctenar);
    }

    public void odebratCtenare(Ctenar ctenar) {
        seznamCtenaru.remove(ctenar);
    }

    public void vytvoritVypujcku(String emailCtenare, String nazevKnihy) {
        Ctenar ctenar = najitCtenare(emailCtenare);
        Kniha kniha = najitKnihu(nazevKnihy);

        if (ctenar != null && kniha != null && kniha.isDostupnost()) {
            Vypujcka vypujcka = new Vypujcka(ctenar, kniha, new Date());
            ctenar.pridatVypujcku(vypujcka);
            kniha.setDostupnost(false);
        }
    }

    public void vratitKnihu(String emailCtenare, String nazevKnihy) {
        Ctenar ctenar = najitCtenare(emailCtenare);
        if (ctenar != null) {
            for (Vypujcka v : ctenar.getSeznamVypujcek()) {
                if (v.getKniha().getNazev().equals(nazevKnihy) && v.getDatumVraceni() == null) {
                    v.setDatumVraceni(new Date());
                    v.getKniha().setDostupnost(true);
                    break;
                }
            }
        }
    }

    public Ctenar najitCtenare(String email) {
        for (Ctenar c : seznamCtenaru) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public Kniha najitKnihu(String nazev) {
        for (Kniha k : seznamKnih) {
            if (k.getNazev().equals(nazev)) {
                return k;
            }
        }
        return null;
    }

    public void zobrazitDostupneKnihy() {
        seznamKnih.stream().filter(Kniha::isDostupnost).forEach(System.out::println);
    }

    public void zobrazitHistoriiVypujcek(String emailCtenare) {
        Ctenar ctenar = najitCtenare(emailCtenare);
        if (ctenar != null) {
            ctenar.getSeznamVypujcek().forEach(System.out::println);
        }
    }

    public void ulozitDoSouboru(String soubor) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(soubor))) {
            out.writeObject(seznamKnih);
            out.writeObject(seznamCtenaru);
        }
    }

    @SuppressWarnings("unchecked")
    public void nacistZeSouboru(String soubor) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(soubor))) {
            seznamKnih = (List<Kniha>) in.readObject();
            seznamCtenaru = (List<Ctenar>) in.readObject();
        }
    }
}
