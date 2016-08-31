package ruokalista.fileOps;

import org.springframework.stereotype.Component;
import ruokalista.utility.Formater;
import ruokalista.wrappers.Ostos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class TiedostonLukija {

    private Formater formater;

    public TiedostonLukija(Formater pFormater) {
        this.formater = pFormater;
    }

    public List<Ostos> lueTiedosto(String tiedosto) {
        List<Ostos> ostokset = new ArrayList();
        try {
            Scanner scanner = new Scanner(new File(tiedosto));
            while(scanner.hasNextLine()) {
                Ostos ostos = formater.stringToOstos(scanner.nextLine());
                ostokset.add(ostos);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(ostokset);
        return ostokset;
    }

    public boolean tiedostoOnOlemassa(String tiedosto) {
        try {
            Scanner scanner = new Scanner(new File(tiedosto));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public int viimeinenIdTiedostossa(String tiedosto) {
        List<Ostos> ostokset = lueTiedosto(tiedosto);
        System.out.println(ostokset.get(ostokset.size()-1).getId());
        return ostokset.get(ostokset.size()-1).getId();
    }
}
