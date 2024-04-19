public class Main {
    public static void main(String[] args) {
        Knihovna knihovna = new Knihovna();
        knihovna = knihovna.nacistZeSouboru("knihy.ser");
        if (knihovna == null) {
            knihovna = new Knihovna();
        }
        knihovna.zobrazitDostupneKnihy();

        Kniha kniha1 = new Kniha("Kniha1", "Autor1", 2001);
        Kniha kniha2 = new Kniha("Kniha2", "Autor2", 2002);
        Kniha kniha3 = new Kniha("Kniha3", "Autor3", 2003);
        Kniha kniha4 = new Kniha("Kniha4", "Autor4", 2004);

        knihovna.pridatKnihu(kniha1);
        knihovna.pridatKnihu(kniha2);
        knihovna.pridatKnihu(kniha3);
        knihovna.pridatKnihu(kniha4);

        knihovna.zobrazitDostupneKnihy();

        Ctenar ctenar1 = new Ctenar("Ctenar1", "Prijmeni1", "ctenar1@email.com");

        knihovna.pridatCtenare(ctenar1);

        knihovna.vytvoritVypujcku("ctenar1@email.com", "Kniha2");

        knihovna.zobrazitDostupneKnihy();

        knihovna.ukazatHistorii("ctenar1@email.com");

        knihovna.vratitKnihu("Kniha2", "ctenar1@email.com");

        knihovna.zobrazitDostupneKnihy();

        knihovna.ulozitDoSouboru("knihy.ser");
    }
}
