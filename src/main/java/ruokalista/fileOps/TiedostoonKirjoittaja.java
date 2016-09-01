package ruokalista.fileOps;

import org.springframework.stereotype.Component;
import ruokalista.utility.Formater;
import ruokalista.wrappers.Ostos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class TiedostoonKirjoittaja {

    private Formater formater;

    public TiedostoonKirjoittaja(Formater pFormater) {
        this.formater = pFormater;
    }

    public void kirjoitaTiedostoon(Ostos ostos) {
        try {
            FileWriter kirjoittaja = new FileWriter("ostoslista.txt", true);
            kirjoittaja.write(formater.ostosToString(ostos)+"\n");
            kirjoittaja.close();
        } catch (IOException e) {
            System.out.println("Tiedostoon kirjoittaminen epäonnistui!");
        }
    }

    public void muutaTiedostossa(List<Ostos> kaikkiOstokset, List<Ostos> muutettavat) {
        try {
            FileWriter kirjoittaja = new FileWriter("ostoslista.txt");
            for (Ostos ostos1 : kaikkiOstokset) {
                boolean muutettavaLoytyi = false;
                for (Ostos ostos2 : muutettavat) {
                    if (ostos1.equals(ostos2)) {
                        muutettavaLoytyi = true;
                    }
                }
                if (ostos1.getOstettu() == false) {
                    ostos1.setOstettu(muutettavaLoytyi);
                }
                kirjoittaja.write(formater.ostosToString(ostos1)+"\n");
            }
            kirjoittaja.close();
        } catch (IOException e) {
            System.out.println("Ostoksen poistaminen tiedostosta epäonnistui.");
        }
    }
}
