package ruokalista.utility.database;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;
import ruokalista.Application;
import ruokalista.database.OstosJDBCTemplate;
import ruokalista.wrappers.Ostos;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class OstosJDBCTemplateTest {

    @Autowired
    private OstosJDBCTemplate ostoslista;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(SimpleDriverDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    @Transactional
    public void emptyDatabase() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "ostos");
    }

    @Test
    @Transactional
    public void itIsPossibleAddPurhase() {
        Ostos o = luoOstos("Maito", 1, "kg", false);
        assertEquals(0, rivienLkm());
        ostoslista.tallennaOstos(o);
        assertEquals(1, rivienLkm());
    }

    @Test
    @Transactional
    public void itIsPossibleToAddMultiplePurchases() {
        Ostos o1 = luoOstos("Maito", 1, "kg", false);
        Ostos o2 = luoOstos("Suklaa", 1, "pkt", true);
        Ostos o3 = luoOstos("Karkki", 2, "pss", true);
        assertEquals(0, rivienLkm());
        ostoslista.tallennaOstos(o1);
        assertEquals(1, rivienLkm());
        ostoslista.tallennaOstos(o2);
        assertEquals(2, rivienLkm());
        ostoslista.tallennaOstos(o3);
        assertEquals(3, rivienLkm());
    }

    public Ostos luoOstos(String nimi, int maara, String yksikko, boolean ostettu) {
        Ostos o = new Ostos();
        o.setNimi(nimi);
        o.setMaara(maara);
        o.setYksikko(yksikko);
        o.setOstettu(ostettu);
        return o;
    }

    public int rivienLkm() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, "ostos");
    }
}
