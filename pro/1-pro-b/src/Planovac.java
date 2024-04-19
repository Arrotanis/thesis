import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Planovac implements Serializable {
    private List<Ukol> seznamUkolu;
    public Planovac() {
        seznamUkolu = new ArrayList<>();
    }

    public void pridatUkol(Ukol ukol) {
        seznamUkolu.add(ukol);
    }

    public void odebratUkol(String name) {
        Ukol ukol = najitPodleJmena(name);
        seznamUkolu.remove(ukol);
    }


    public void zobrazitVsechnyUkoly() {
        for (Ukol ukol : seznamUkolu) {
            System.out.println("Název: " + ukol.getNazev() +" Popis: " + ukol.getPopis()+ " Dokončen: " + ukol.isDokoncen());
            System.out.println();
        }
    }

    public void zobrazitNespleneUkoly() {
        for (Ukol ukol : seznamUkolu) {
            if (ukol.isDokoncen() == false) {
                System.out.println("Název: " + ukol.getNazev() +" Popis: " + ukol.getPopis()+ " Dokončen: " + ukol.isDokoncen());
                System.out.println();
            }
        }
    }
    public void oznacitJakoDokonceny(String taskName) {
        Ukol ukol = najitPodleJmena(taskName);
        if (ukol != null && ukol.isDokoncen() == false) {
            ukol.setDokoncen(true);
        }
    }
    public Ukol najitPodleJmena(String taskName) {
        for (Ukol ukol : seznamUkolu) {
            if (ukol.getNazev()==taskName) {
                return ukol;
            }
        }
        return null;
    }

    public void ulozitDoSouboru(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Planovac nacistZeSouboru(String fileName) {
        Planovac planovac = new Planovac();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            planovac = (Planovac) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return planovac;
    }
}