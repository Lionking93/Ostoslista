package ruokalista.querys;

import org.springframework.stereotype.Component;
import ruokalista.wrappers.Ostos;

import java.util.List;

@Component
public class Ostoslista {
    private List<Ostos> ostokset;

    public Ostoslista() {
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
    }
}
