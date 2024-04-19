import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Planovac {
    private List<Ukol> ukoly = new ArrayList<>();

    public void pridatUkol(Ukol ukol) {
        ukoly.add(ukol);
    }

    public void odstranitUkol(String nazev) {
        ukoly.removeIf(ukol -> ukol.getNazev().equals(nazev));
    }

    public void oznacitUkolJakoSplneny(String nazev) {
        for (Ukol ukol : ukoly) {
            if (ukol.getNazev().equals(nazev)) {
                ukol.setSplneny(true);
                break;
            }
        }
    }

    public void zobrazitVsechnyUkoly() {
        ukoly.forEach(System.out::println);
    }

    public void zobrazitNesplneneUkoly() {
        ukoly.stream().filter(ukol -> !ukol.isSplneny()).forEach(System.out::println);
    }

    public void ulozitDoSouboru(String soubor) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(soubor))) {
            oos.writeObject(ukoly);
        }
    }

    @SuppressWarnings("unchecked")
    public void nacistZeSouboru(String soubor) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(soubor))) {
            ukoly = (List<Ukol>) ois.readObject();
        }
    }
}
