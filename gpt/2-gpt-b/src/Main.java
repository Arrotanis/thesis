public class Main {
    public static void main(String[] args) {
        Knihovna knihovna = Knihovna.nacistZSouboru("knihovna.dat");
        if (knihovna == null) {
            knihovna = new Knihovna();
        }

        // Zobrazení dostupných knih
        System.out.println("Dostupné knihy při spuštění:");
        knihovna.zobrazitDostupneKnihy();

        // Přidání knih
        knihovna.pridatKnihu(new Kniha("Harry Potter", "J.K. Rowling", 1997));
        knihovna.pridatKnihu(new Kniha("Hobit", "J.R.R. Tolkien", 1937));

        // Zobrazení dostupných knih po přidání
        System.out.println("\nDostupné knihy po přidání:");
        knihovna.zobrazitDostupneKnihy();

        // Přidání čtenáře
        Ctenar ctenar = new Ctenar("Jan", "Novák", "jan.novak@email.com");
        knihovna.pridatCtenare(ctenar);

        // Vytvoření výpůjčky
        knihovna.vytvoritVypujcku("jan.novak@email.com", "Harry Potter");

        // Zobrazení dostupných knih po výpůjčce
        System.out.println("\nDostupné knihy po výpůjčce:");
        knihovna.zobrazitDostupneKnihy();

        // Zobrazení historie výpůjček pro čtenáře
        System.out.println("\nHistorie výpůjček pro Jan Novák:");
        knihovna.zobrazitHistoriiVypujcekCtenare("jan.novak@email.com");

        // Vrácení knihy
        knihovna.vratitKnihu("Harry Potter");

        // Zobrazení dostupných knih po vrácení
        System.out.println("\nDostupné knihy po vrácení:");
        knihovna.zobrazitDostupneKnihy();

        // Uložení dat do souboru
        knihovna.ulozitDoSouboru("knihovna.dat");

        System.out.println("\nProgram ukončen, data uložena.");
    }
}
