package ruokalista.fileOps;

import ruokalista.wrappers.Ostos;

import java.util.List;

public interface TiedonKasittelyOperaatiot {
    boolean tallennaOstos(Ostos ostos);
    List<Ostos> haeOstokset();
    boolean poistaOstoksia(List<Ostos> ostos);
}
