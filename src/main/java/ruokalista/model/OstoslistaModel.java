package ruokalista.model;

import org.springframework.stereotype.Component;
import ruokalista.fileOps.TiedonKasittelyOperaatiot;
import ruokalista.wrappers.Ostos;

import java.util.List;

@Component
public class OstoslistaModel {

    private TiedonKasittelyOperaatiot tiedostojenKasittelija;

    public OstoslistaModel(TiedonKasittelyOperaatiot pTiedostojenKasittelija) {
        this.tiedostojenKasittelija = pTiedostojenKasittelija;
    }

    public void tallennaOstos(Ostos ostos) {
        this.tiedostojenKasittelija.tallennaOstos(ostos);
    }

    public List<Ostos> haeOstokset() {
        return this.tiedostojenKasittelija.haeOstokset();
    }

    public void poistaOstoksia(List<Ostos> ostokset) {
        this.tiedostojenKasittelija.poistaOstoksia(ostokset);
    }
}
