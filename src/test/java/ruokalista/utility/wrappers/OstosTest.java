package ruokalista.utility.wrappers;

import org.junit.Before;
import org.junit.Test;
import ruokalista.wrappers.Ostos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OstosTest {

    public Ostos luoOstos(int pId, String pNimi, String pMaara, String pYksikko) {
        Ostos ostos = new Ostos();
        ostos.setId(pId);
        ostos.setNimi(pNimi);
        ostos.setMaara(pMaara);
        ostos.setYksikko(pYksikko);
        return ostos;
    }

    @Test
    public void compareToRecognizesTwoPurchasesWithSameId() {
        Ostos ostos1 = luoOstos(1, "Maito", "3", "l");

        Ostos ostos2 = luoOstos(1, "Suklaa", "5", "");

        assertEquals(0, ostos1.compareTo(ostos2));
        assertEquals(true, ostos1.equals(ostos2));
    }

    @Test
    public void listOfPurchasesAreAddedCorrectly() {
        List<Ostos> ostokset = new ArrayList();

        for(int i = 5; i > 0; i--) {
            Ostos ostos = luoOstos(i, "Maito"+i, "2", "l");
            ostokset.add(ostos);
        }

        assertEquals(5, ostokset.get(0).getId());
        assertEquals(4, ostokset.get(1).getId());
        assertEquals(3, ostokset.get(2).getId());
        assertEquals(2, ostokset.get(3).getId());
        assertEquals(1, ostokset.get(4).getId());
    }

    @Test
    public void listOfPurchasesAreSortedCorrectly() {
        List<Ostos> ostokset = new ArrayList();

        for(int i = 5; i > 0; i--) {
            Ostos ostos = luoOstos(i, "Maito"+i, "2", "l");
            ostokset.add(ostos);
        }

        Collections.sort(ostokset);

        assertEquals(1, ostokset.get(0).getId());
        assertEquals(2, ostokset.get(1).getId());
        assertEquals(3, ostokset.get(2).getId());
        assertEquals(4, ostokset.get(3).getId());
        assertEquals(5, ostokset.get(4).getId());
    }
}
