package ruokalista.utility;

import org.junit.Test;
import ruokalista.wrappers.Ostos;

import static org.junit.Assert.assertEquals;

public class FormaterTest {

    private Formater formater;

    public FormaterTest() {
        this.formater = new Formater();
    }

    @Test
    public void formaterFormatsOstosToStringCorrectly() {
        Ostos ostos = new Ostos();
        ostos.setId(1);
        ostos.setNimi("Maito");
        ostos.setMaara("2");
        ostos.setYksikko("l");
        assertEquals("1 Maito 2 l", formater.ostosToString(ostos));
    }

    @Test
    public void formaterFormatsStringToOstosCorrectly() {
        String ostosString = "1 Maito 2 l";
        assertEquals("1", formater.stringToOstos(ostosString).getId()+"");
        assertEquals("Maito", formater.stringToOstos(ostosString).getNimi());
        assertEquals("2", formater.stringToOstos(ostosString).getMaara());
        assertEquals("l", formater.stringToOstos(ostosString).getYksikko());
    }
}
