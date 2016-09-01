package ruokalista.utility.utility;

import org.junit.Test;
import ruokalista.utility.Formater;
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
        ostos.setNimi("Mummon muusi");
        ostos.setMaara("2");
        ostos.setYksikko("l");
        ostos.setOstettu(true);
        assertEquals("1, Mummon muusi, 2, l, true", formater.ostosToString(ostos));
    }

    @Test
    public void formaterFormatsStringToOstosCorrectly() {
        String ostosString = "1, Mummon muusi, 2, l, true";
        assertEquals("1", formater.stringToOstos(ostosString).getId()+"");
        assertEquals("Mummon muusi", formater.stringToOstos(ostosString).getNimi());
        assertEquals("2", formater.stringToOstos(ostosString).getMaara());
        assertEquals("l", formater.stringToOstos(ostosString).getYksikko());
        assertEquals(true, formater.stringToOstos(ostosString).getOstettu());
    }

    @Test
    public void formaterFormatsStringToOstosCorrectlyIfInfoMissing() {
        String ostosString = "1, Pommac limonadi";
        assertEquals(1, formater.stringToOstos(ostosString).getId());
        assertEquals("Pommac limonadi", formater.stringToOstos(ostosString).getNimi());
        assertEquals("", formater.stringToOstos(ostosString).getMaara());
        assertEquals("", formater.stringToOstos(ostosString).getYksikko());
        assertEquals(false, formater.stringToOstos(ostosString).getOstettu());
    }
}
