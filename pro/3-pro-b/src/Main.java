public class Main {
    public static void main(String[] args) {
        SpravaFinanci system = new SpravaFinanci();

        Transakce transakce1 = new Transakce(50000,  "Prijem1");
        system.pridatTransakci(transakce1);
        Transakce transakce2 = new Transakce(-5000,  "Vydej1");
        system.pridatTransakci(transakce2);
        Transakce transakce3 = new Transakce(-1000,  "Vydej2");
        system.pridatTransakci(transakce3);
        Transakce transakce4 = new Transakce(-3000,  "Vydej3");
        system.pridatTransakci(transakce4);
        Transakce transakce5 = new Transakce(12000,  "Prijem2");
        system.pridatTransakci(transakce5);


        system.zobrazitTransakce();
        system.zobrazitPrijmy();
        system.zobrazitVydaje();
        system.zobrazitZustatek();
    }
}