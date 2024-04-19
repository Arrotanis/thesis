import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Main {
    public static void main(String[] args) {
        Planovac planovac = new Planovac();

        try {
            planovac.nacistZeSouboru("ukoly.dat");
            System.out.println("Ukoly byly uspesne nacteny ze souboru.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nepodarilo se nacist ukoly ze souboru. Vytvarim nove ukoly.");
        }

        // Přidání ukolů
        planovac.pridatUkol(new Ukol("Nakupovani", "Koupit mleko, chleba, maslo"));
        planovac.pridatUkol(new Ukol("Studium", "Precist 2 kapitoly z knihy"));

        // Zobrazení všech ukolů
        System.out.println("\nVsechny ukoly:");
        planovac.zobrazitVsechnyUkoly();

        // Označení ukolu jako splneny
        planovac.oznacitUkolJakoSplneny("Nakupovani");

        // Zobrazení pouze nesplněných ukolů
        System.out.println("\nPouze nesplnene ukoly:");
        planovac.zobrazitNesplneneUkoly();

        // Uložení ukolů do souboru
        try {
            planovac.ulozitDoSouboru("ukoly.dat");
            System.out.println("Ukoly byly uspesne ulozeny do souboru.");
        } catch (IOException e) {
            System.out.println("Nepodarilo se ulozit ukoly do souboru.");
        }
    }
}
