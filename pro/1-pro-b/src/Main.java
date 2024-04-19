public class Main {
    public static void main(String[] args) {
        Planovac planovac = new Planovac();
        planovac = planovac.nacistZeSouboru("planovac.ser");

        if (planovac == null) {
            planovac = new Planovac();
        }
        planovac.zobrazitVsechnyUkoly();

        Ukol ukol1 = new Ukol("Ukol1", "Popis ukolu 1");
        planovac.pridatUkol(ukol1);
        Ukol ukol2 = new Ukol("Ukol2", "Popis ukolu 2");
        planovac.pridatUkol(ukol2);
        Ukol ukol3 = new Ukol("Ukol3", "Popis ukolu 3");
        planovac.pridatUkol(ukol3);
        Ukol ukol4 = new Ukol("Ukol4", "Popis ukolu 4");
        planovac.pridatUkol(ukol4);
        Ukol ukol5 = new Ukol("Ukol5", "Popis ukolu 5");
        planovac.pridatUkol(ukol5);

        planovac.oznacitJakoDokonceny("Ukol3");
        planovac.zobrazitNespleneUkoly();

        planovac.ulozitDoSouboru("planovac.ser");
    }
}