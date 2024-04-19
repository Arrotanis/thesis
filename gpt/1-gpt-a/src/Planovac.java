import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Planovac implements Serializable {
    private List<Ukol> ukoly = new ArrayList<>();

    public void pridatUkol(Ukol ukol) {
        ukoly.add(ukol);
    }

    public void odstranitUkol(String nazev) {
        ukoly.removeIf(ukol -> ukol.getNazev().equals(nazev));
    }

    public Ukol vyhledatUkol(String nazev) {
        return ukoly.stream()
                .filter(ukol -> ukol.getNazev().equals(nazev))
                .findFirst()
                .orElse(null);
    }

    public void oznacitUkolJakoSplneny(String nazev) {
        Ukol ukol = vyhledatUkol(nazev);
        if (ukol != null) {
            ukol.setSplneny(true);
        }
    }

    public void zobrazitVsechnyUkoly() {
        ukoly.forEach(System.out::println);
    }

    public void zobrazitNesplneneUkoly() {
        ukoly.stream()
                .filter(ukol -> !ukol.isSplneny())
                .forEach(System.out::println);
    }

    public void ulozitDoSouboru(String soubor) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(soubor))) {
            out.writeObject(ukoly);
        }
    }

    @SuppressWarnings("unchecked")
    public void nacistZeSouboru(String soubor) throws IOException, ClassNotFoundException {
        File file = new File(soubor);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(soubor))) {
                ukoly = (List<Ukol>) in.readObject();
            }
        }
    }
}
