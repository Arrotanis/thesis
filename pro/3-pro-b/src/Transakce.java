import java.util.Date;

class Transakce {
    private int hodnota;
    private String datum;
    private String popis;

    public Transakce(int hodnota, String popis) {
        this.hodnota = hodnota;
        this.datum = new Date().toString();
        this.popis = popis;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public int getHodnota() {
        return hodnota;
    }

    public String getDatum() {
        return datum;
    }

    public String getPopis() {
        return popis;
    }
}
