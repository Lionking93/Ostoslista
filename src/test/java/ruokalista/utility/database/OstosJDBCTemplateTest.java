/*package ruokalista.utility.database;

import org.h2.jdbcx.JdbcDataSource;
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

    public void setDataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:~/test");
        ds.setUser("sa");
        ds.setPassword("sa");
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Before
    public void initializeDataSource() {
        setDataSource();
    }

    @Test
    @Transactional
    public void itIsPossibleAddPurhase() {
        Ostos o = luoOstos("Maito", 1, "kg", false);
        assertEquals(0, JdbcTestUtils.countRowsInTable(jdbcTemplate, "ostos"));
        ostoslista.tallennaOstos(o);
    }

    @Test
    @Transactional
    public void itIsPossibleToAddMultiplePurchases() {
        Ostos o1 = luoOstos("Maito", 1, "kg", false);
        Ostos o2 = luoOstos("Suklaa", 1, "pkt", true);
        Ostos o3 = luoOstos("Karkki", 2, "pss", true);
        ostoslista.tallennaOstos(o1);
        ostoslista.tallennaOstos(o2);
        ostoslista.tallennaOstos(o3);
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
    //    return JdbcTestUtils.countRowsInTable(jdbcTemplate, "ostos");
        return -1;
    }
}*/
