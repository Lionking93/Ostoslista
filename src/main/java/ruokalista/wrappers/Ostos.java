package ruokalista.wrappers;

import java.util.Comparator;

public class Ostos implements Comparable {
    private int id;
    private String nimi;
    private String maara;
    private String yksikko;

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

    public String getMaara() {
        return this.maara;
    }

    public void setMaara(String pMaara) {
        this.maara = pMaara;
    }

    public String getYksikko() {
        return this.yksikko;
    }

    public void setYksikko(String pYksikko) {
        this.yksikko = pYksikko;
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
}
