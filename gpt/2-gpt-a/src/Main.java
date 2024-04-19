import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Knihovna knihovna = new Knihovna();

        try {
            knihovna.nacistZeSouboru("knihovna.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Data nebyla nalezena, vytváříme novou knihovnu.");
        }

        System.out.println("Dostupné knihy:");
        knihovna.zobrazitDostupneKnihy();

        Kniha kniha1 = new Kniha("Jméno větru", "Patrick Rothfuss", 2007);
        knihovna.pridatKnihu(kniha1);

        System.out.println("Po přidání knihy:");
        knihovna.zobrazitDostupneKnihy();

        Ctenar ctenar1 = new Ctenar("Jan", "Novák", "jan.novak@email.cz");
        knihovna.pridatCtenare(ctenar1);

        knihovna.vytvoritVypujcku(ctenar1.getEmail(), kniha1.getNazev());

        System.out.println("Po vypůjčení knihy:");
        knihovna.zobrazitDostupneKnihy();

        knihovna.zobrazitHistoriiVypujcek(ctenar1.getEmail());

        knihovna.vratitKnihu(ctenar1.getEmail(), kniha1.getNazev());

        System.out.println("Po vrácení knihy:");
        knihovna.zobrazitDostupneKnihy();

        try {
            knihovna.ulozitDoSouboru("knihovna.dat");
        } catch (IOException e) {
            System.err.println("Nepodařilo se uložit knihovnu.");
        }
    }
}
