import java.util.ArrayList;

class SpravaFinanci {
    private ArrayList<Transakce> seznamTransakci;

    public SpravaFinanci() {
        this.seznamTransakci = new ArrayList<>();
    }

    public void pridatTransakci(Transakce transakce) {
        seznamTransakci.add(transakce);
    }

    public void smazatTransakci(int index) {
        if (index >= 0 && index < seznamTransakci.size()) {
            seznamTransakci.remove(index);
        }
    }

    public void zobrazitTransakce() {
        System.out.println("Všechny:");
        for (int i = 0; i < seznamTransakci.size(); i++) {
            Transakce transakce = seznamTransakci.get(i);
            System.out.println("[" + i + "] " + transakce.getDatum() + " " + +
                    transakce.getHodnota() + " " + transakce.getPopis());
        }
    }

    public void zobrazitPrijmy() {
        System.out.println("Příjmy:");
        for (Transakce transakce : seznamTransakci) {
            if (transakce.getHodnota() > 0) {
                System.out.println(transakce.getDatum() + " " + transakce.getHodnota() + " " + transakce.getPopis());
            }
        }
    }

    public void zobrazitVydaje() {
        System.out.println("Výdaje:");
        for (Transakce transakce : seznamTransakci) {
            if (transakce.getHodnota() < 0) {
                System.out.println(transakce.getDatum() + "  " + transakce.getHodnota() + " " + transakce.getPopis());
            }
        }
    }

    public void zobrazitZustatek() {
        int zustatek = 0;
        for (Transakce transakce : seznamTransakci) {
            zustatek += transakce.getHodnota();
        }
        System.out.println("Zůstatek: " + zustatek);
    }
}
