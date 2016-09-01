package ruokalista.querys;

import org.springframework.stereotype.Component;
import ruokalista.fileOps.TiedostonLukija;
import ruokalista.wrappers.Ostos;

import java.util.List;

@Component
public class Ostoslista {
    private List<Ostos> ostokset;
    private TiedostonLukija tiedostonLukija;

    public Ostoslista(TiedostonLukija pTiedostonLukija) {
        this.tiedostonLukija = pTiedostonLukija;
        this.ostokset = this.tiedostonLukija.lueTiedosto("ostoslista.txt");
    }

    public Ostos viimeinen() {
        return this.ostokset.get(this.ostokset.size()-1);
    }

    public List<Ostos> getOstoslista() {
        return this.ostokset;
    }

    public boolean onTyhja() {
        return this.getOstoslista().isEmpty();
    }

    public void paivita() {
        this.ostokset = this.tiedostonLukija.lueTiedosto("ostoslista.txt");
    }
}
