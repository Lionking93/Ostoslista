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

    public boolean kirjoitaTiedostoon(Ostos ostos) {
        try {
            FileWriter kirjoittaja = new FileWriter("ostoslista.txt", true);
            kirjoittaja.write(formater.ostosToString(ostos)+"\n");
            kirjoittaja.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean poistaTiedostosta(List<Ostos> kaikkiOstokset, List<Ostos> poistettavat) {
        try {
            FileWriter kirjoittaja = new FileWriter("ostoslista.txt");
            boolean poistettavaLoytyi = false;
            for (Ostos ostos1 : kaikkiOstokset) {
                for (Ostos ostos2 : poistettavat) {
                    if (ostos1 == ostos2) {
                        poistettavaLoytyi = true;
                    }
                }
                if (!poistettavaLoytyi) {
                    kirjoittaja.write(formater.ostosToString(ostos1)+"\n");
                }
            }
            kirjoittaja.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
