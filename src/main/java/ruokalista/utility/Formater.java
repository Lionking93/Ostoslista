package ruokalista.utility;

import org.springframework.stereotype.Component;
import ruokalista.wrappers.Ostos;

@Component
public class Formater {

    public Formater() {
    }

    public String ostosToString(Ostos ostos) {
        return ostos.getId() + ", " + ostos.getNimi() + ", " + ostos.getMaara() + ", " + ostos.getYksikko() +
                ", " + ostos.getOstettu();
    }

    public Ostos stringToOstos(String pOstos) {
        String[] ostoksenOsat = pOstos.split(",");
        Ostos ostos = new Ostos();
        if (ostoksenOsat.length > 0) {
            ostos.setId(Integer.parseInt(ostoksenOsat[0].trim()));
        }
        if (ostoksenOsat.length > 1) {
            ostos.setNimi(ostoksenOsat[1].trim());
        } else {
            ostos.setNimi("");
        }
        if (ostoksenOsat.length > 2) {
            ostos.setMaara(ostoksenOsat[2].trim());
        } else {
            ostos.setMaara("");
        }
        if (ostoksenOsat.length > 3) {
            ostos.setYksikko(ostoksenOsat[3].trim());
        } else {
            ostos.setYksikko("");
        }
        if (ostoksenOsat.length > 4) {
            ostos.setOstettu(ostoksenOsat[4].trim().equals("true"));
        }
        return ostos;
    }
}

