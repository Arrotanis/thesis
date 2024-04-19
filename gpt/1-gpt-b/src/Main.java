import java.io.*;

public class Main {
    public static void main(String[] args) {
        Planovac planovac = new Planovac();

        // Načtení dat ze souboru
        try {
            planovac.nacistZeSouboru("ukoly.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nepodařilo se načíst úkoly ze souboru.");
        }

        // Demonstrace funkcí
        planovac.pridatUkol(new Ukol("Nakoupit", "Koupit mléko, chleba, máslo"));
        planovac.pridatUkol(new Ukol("Cvičení", "Jít na hodinu jogi"));
        planovac.zobrazitVsechnyUkoly();
        planovac.oznacitUkolJakoSplneny("Nakoupit");
        System.out.println("Nesplněné úkoly:");
        planovac.zobrazitNesplneneUkoly();

        // Uložení do souboru
        try {
            planovac.ulozitDoSouboru("ukoly.dat");
        } catch (IOException e) {
            System.out.println("Nepodařilo se uložit úkoly do souboru.");
        }
    }
}
