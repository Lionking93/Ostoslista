package ruokalista.fileOps;

import ruokalista.wrappers.Ostos;

import java.util.List;

public interface TiedonKasittelyOperaatiot {
    void tallennaOstos(Ostos ostos);
    List<Ostos> haeOstokset();
    void merkitseOstoksiaOstetuiksi(List<Ostos> ostos);
}
