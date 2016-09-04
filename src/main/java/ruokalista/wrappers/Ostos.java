package ruokalista.wrappers;

import java.util.Comparator;

public class Ostos implements Comparable {
    private int id;
    private String nimi;
    private int maara;
    private String yksikko;
    private boolean ostettu;

    public int getId() {
        return this.id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void setNimi(String pNimi) {
        this.nimi = pNimi;
    }

    public int getMaara() {
        return this.maara;
    }

    public void setMaara(int pMaara) {
        this.maara = pMaara;
    }

    public String getYksikko() {
        return this.yksikko;
    }

    public void setYksikko(String pYksikko) {
        this.yksikko = pYksikko;
    }

    public boolean getOstettu() {
        return this.ostettu;
    }

    public void setOstettu(boolean pOstettu) {
        this.ostettu = pOstettu;
    }

    public int compareTo(Object o) {
        Ostos verrattava = (Ostos) o;
        if (this.id < verrattava.getId()) {
            return -1;
        } else if (this.id > verrattava.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        Ostos verrattava = (Ostos) o;
        return this.id == verrattava.getId() ? true : false;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nimi + " " + this.maara + " " + this.yksikko + " " + this.ostettu;
    }
}
