package ruokalista.fileOps;

import org.springframework.stereotype.Component;
import ruokalista.wrappers.Ostos;

import java.io.File;
import java.util.List;

@Component
public class TiedostoOperaatiot implements TiedonKasittelyOperaatiot {

    private TiedostonLukija tiedostonLukija;
    private TiedostoonKirjoittaja tiedostoonKirjoittaja;

    public TiedostoOperaatiot(TiedostonLukija pTiedostonLukija, TiedostoonKirjoittaja pTiedostoonKirjoittaja) {
        this.tiedostonLukija = pTiedostonLukija;
        this.tiedostoonKirjoittaja = pTiedostoonKirjoittaja;
    }

    public boolean tallennaOstos(Ostos ostos) {
        if (!tiedostonLukija.tiedostoOnOlemassa("ostoslista.txt")) {
            ostos.setId(1);
        } else {
            ostos.setId(tiedostonLukija.viimeinenIdTiedostossa("ostoslista.txt")+1);
        }
        return tiedostoonKirjoittaja.kirjoitaTiedostoon(ostos);
    }

    public List<Ostos> haeOstokset() {
        List<Ostos> ostokset = tiedostonLukija.lueTiedosto("ostoslista.txt");
        return ostokset;
    }

    public boolean poistaOstoksia(List<Ostos> poistettavat) {
        List<Ostos> kaikkiOstokset = haeOstokset();
        return tiedostoonKirjoittaja.poistaTiedostosta(kaikkiOstokset, poistettavat);
    }
}
