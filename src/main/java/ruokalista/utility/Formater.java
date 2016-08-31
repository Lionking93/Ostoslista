package ruokalista.utility;

import org.springframework.stereotype.Component;
import ruokalista.wrappers.Ostos;

@Component
public class Formater {

    public Formater() {
    }

    public String ostosToString(Ostos ostos) {
        return ostos.getId() + " " + ostos.getNimi() + " " + ostos.getMaara() + " " + ostos.getYksikko();
    }

    public Ostos stringToOstos(String pOstos) {
        String[] ostoksenOsat = pOstos.split(" ");
        Ostos ostos = new Ostos();
        if (ostoksenOsat.length > 0) {
            ostos.setId(Integer.parseInt(ostoksenOsat[0]));
        }
        if (ostoksenOsat.length > 1) {
            ostos.setNimi(ostoksenOsat[1]);
        }
        if (ostoksenOsat.length > 2) {
            ostos.setMaara(ostoksenOsat[2]);
        }
        if (ostoksenOsat.length > 3) {
            ostos.setYksikko(ostoksenOsat[3]);
        }
        return ostos;
    }
}

