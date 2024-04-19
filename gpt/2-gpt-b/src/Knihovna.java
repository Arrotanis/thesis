import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Knihovna implements Serializable {
    private List<Kniha> knihy = new ArrayList<>();
    private List<Ctenar> ctenari = new ArrayList<>();

    // Přidání knihy do knihovny
    public void pridatKnihu(Kniha kniha) {
        knihy.add(kniha);
    }

    // Odstranění knihy z knihovny
    public void odstranitKnihu(String nazev) {
        knihy.removeIf(kniha -> kniha.getNazev().equals(nazev));
    }

    // Přidání čtenáře do knihovny
    public void pridatCtenare(Ctenar ctenar) {
        ctenari.add(ctenar);
    }

    // Odebrání čtenáře z knihovny
    public void odebratCtenare(String email) {
        ctenari.removeIf(ctenar -> ctenar.getEmail().equals(email));
    }

    // Vytvoření nové výpůjčky
    public void vytvoritVypujcku(String emailCtenare, String nazevKnihy) {
        Ctenar ctenar = ctenari.stream().filter(c -> c.getEmail().equals(emailCtenare)).findFirst().orElse(null);
        Kniha kniha = knihy.stream().filter(k -> k.getNazev().equals(nazevKnihy) && k.isDostupnost()).findFirst().orElse(null);

        if (ctenar != null && kniha != null) {
            Vypujcka vypujcka = new Vypujcka(ctenar, kniha, new java.util.Date());
            ctenar.addVypujcka(vypujcka);
            kniha.setDostupnost(false);
        }
    }

    // Vrácení knihy
    public void vratitKnihu(String nazevKnihy) {
        knihy.stream().filter(k -> k.getNazev().equals(nazevKnihy))
                .findFirst().ifPresent(kniha -> kniha.setDostupnost(true));
    }

    // Zobrazení dostupných knih
    public void zobrazitDostupneKnihy() {
        List<Kniha> dostupneKnihy = knihy.stream().filter(Kniha::isDostupnost).collect(Collectors.toList());
        System.out.println("Dostupné knihy:");
        dostupneKnihy.forEach(System.out::println);
    }

    // Zobrazení historie výpůjček čtenáře
    public void zobrazitHistoriiVypujcekCtenare(String email) {
        Ctenar ctenar = ctenari.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
        if (ctenar != null) {
            System.out.println("Historie výpůjček pro čtenáře: " + ctenar);
            ctenar.getVypujcky().forEach(System.out::println);
        }
    }

    // Ukládání knihovny do souboru
    public void ulozitDoSouboru(String soubor) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(soubor))) {
            oos.writeObject(this);
            System.out.println("Knihovna byla úspěšně uložena.");
        } catch (IOException e) {
            System.err.println("Nepodařilo se uložit knihovnu do souboru: " + e.getMessage());
        }
    }

    // Statická metoda pro načtení knihovny ze souboru
    public static Knihovna nacistZSouboru(String soubor) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(soubor))) {
            return (Knihovna) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Nepodařilo se načíst knihovnu ze souboru: " + e.getMessage());
            return null;
        }
    }
}
