import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Knihovna implements Serializable {
    private List<Kniha> seznamKnih;
    private List<Ctenar> seznamCtenaru;

    public Knihovna() {
        this.seznamKnih = new ArrayList<>();
        this.seznamCtenaru = new ArrayList<>();
    }

    public List<Kniha> getSeznamKnih() {
        return seznamKnih;
    }

    public List<Ctenar> getSeznamCtenaru() {
        return seznamCtenaru;
    }

    public void setSeznamKnih(List<Kniha> seznamKnih) {
        this.seznamKnih = seznamKnih;
    }

    public void setSeznamCtenaru(List<Ctenar> seznamCtenaru) {
        this.seznamCtenaru = seznamCtenaru;
    }

    public Ctenar najitPodleEmailu(String email) {
        for (Ctenar ctenar : seznamCtenaru
        ) {
            if (ctenar.getEmail()==email) {
                return ctenar;
            }
        }
        return null;
    }

    public Kniha najitPodleNazvu(String nazev, boolean dostupna) {
        for (Kniha kniha : seznamKnih
        ) {
            if (kniha.getNazev()==nazev && kniha.isDostupna() == dostupna) {
                return kniha;
            }
        }
        return null;
    }

    public void pridatKnihu(Kniha kniha) {
        seznamKnih.add(kniha);
    }

    public void smazatKnihu(String nazev, boolean dostupnost) {
        Kniha kniha = najitPodleNazvu(nazev, dostupnost);
        seznamKnih.remove(kniha);
    }

    public void pridatCtenare(Ctenar ctenar) {
        seznamCtenaru.add(ctenar);
    }

    public void smazatCtenare(String email) {
        Ctenar ctenar = najitPodleEmailu(email);
        seznamCtenaru.remove(ctenar);
    }

    public void vytvoritVypujcku(String email, String nazev) {
        Ctenar ctenar = najitPodleEmailu(email);
        Kniha kniha = najitPodleNazvu(nazev, true);
        if (kniha != null && ctenar != null) {
            Vypujcka vypujcka = new Vypujcka(ctenar, kniha);
            kniha.setDostupna(false);
            ctenar.getSeznamVypujcek().add(vypujcka);
        }
    }

    public void vratitKnihu(String nazev, String email) {
        Kniha kniha = najitPodleNazvu(nazev, false);
        Ctenar ctenar = najitPodleEmailu(email);
        if (kniha != null && ctenar != null) {
            for (Vypujcka vypujcka : ctenar.getSeznamVypujcek()
            ) {
                if (kniha == vypujcka.getKniha()) {
                    vypujcka.setDatumVraceni(new Date().toString());
                    kniha.setDostupna(true);
                }
            }
        }
    }

    public void ukazatHistorii(String email) {
        Ctenar ctenar = najitPodleEmailu(email);
        System.out.println("Historie: " + ctenar.getJmeno() + " " + ctenar.getPrijmeni());
        for (Vypujcka vypujcka : ctenar.getSeznamVypujcek()) {
            System.out.println(vypujcka.getKniha().getNazev() + " od: " + vypujcka.getDatumVypujcky() + " do: " + vypujcka.getDatumVraceni());
        }
    }

    public void zobrazitDostupneKnihy() {
        System.out.println("");
        System.out.println("Knihy:");
        for (Kniha kniha : seznamKnih) {
            if (kniha.isDostupna()) {
                System.out.print(kniha.getNazev()+", ");
            }
        }
    }

    public void ulozitDoSouboru(String soubor) {
        try {
            FileOutputStream fileOut = new FileOutputStream(soubor);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Knihovna nacistZeSouboru(String soubor) {
        Knihovna knihovna = new Knihovna();
        try {
            FileInputStream fileIn = new FileInputStream(soubor);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            knihovna = (Knihovna) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return knihovna;
    }
}
