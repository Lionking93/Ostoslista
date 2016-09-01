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
            System.out.println("Tiedostoa ei ole vielä luotu.");
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
}
