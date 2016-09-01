package ruokalista.fileOps;

import org.springframework.stereotype.Component;
import ruokalista.querys.Ostoslista;
import ruokalista.wrappers.Ostos;

import java.util.List;

@Component
public class TiedostoOperaatiot implements TiedonKasittelyOperaatiot {

    private TiedostonLukija tiedostonLukija;
    private TiedostoonKirjoittaja tiedostoonKirjoittaja;
    private Ostoslista ostoslista;

    public TiedostoOperaatiot(TiedostonLukija pTiedostonLukija, TiedostoonKirjoittaja pTiedostoonKirjoittaja,
                              Ostoslista pOstoslista) {
        this.tiedostonLukija = pTiedostonLukija;
        this.tiedostoonKirjoittaja = pTiedostoonKirjoittaja;
        this.ostoslista = pOstoslista;
    }

    public void tallennaOstos(Ostos ostos) {
        if (!tiedostonLukija.tiedostoOnOlemassa("ostoslista.txt") || ostoslista.onTyhja()) {
            ostos.setId(1);
        } else {
            int id = this.ostoslista.viimeinen().getId();
            ostos.setId(id+1);
        }
        tiedostoonKirjoittaja.kirjoitaTiedostoon(ostos);
        ostoslista.paivita();
    }

    public List<Ostos> haeOstokset() {
        ostoslista.paivita();
        return ostoslista.getOstoslista();
    }

    public void merkitseOstoksiaOstetuiksi(List<Ostos> poistettavat) {
        List<Ostos> kaikkiOstokset = haeOstokset();
        tiedostoonKirjoittaja.muutaTiedostossa(kaikkiOstokset, poistettavat);
        ostoslista.paivita();
    }
}
