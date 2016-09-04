package ruokalista.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
import ruokalista.wrappers.Ostos;

import java.util.Collections;
import java.util.List;

@Component
public class OstosJDBCTemplate implements OstosDAO {

    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(SimpleDriverDataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    public void tallennaOstos(Ostos ostos) {
        String SQL = "insert into Ostos VALUES (DEFAULT, ?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, ostos.getNimi(), ostos.getMaara(),
                ostos.getYksikko(), ostos.getOstettu());
        System.out.println("Tallennettiin tietokantaan ostos:");
        System.out.println(ostos.getNimi() + ", " + ostos.getMaara() + ", " +
        ostos.getYksikko() + ", " + ostos.getOstettu());
    }

    public List<Ostos> haeOstokset() {
        String SQL = "select * from ostos";
        List<Ostos> ostokset = jdbcTemplateObject.query(SQL,
                new OstosMapper());
        Collections.sort(ostokset);
        return ostokset;
    }

    public void merkitseOstoksiaOstetuiksi(List<Ostos> ostokset) {
        String SQL = "update Ostos set ostettu = ? where id = ?";
        for (Ostos o : ostokset) {
            jdbcTemplateObject.update(SQL, o.getOstettu(), o.getId());
            System.out.println("Päivitettiin ostoksen jonka id on " + o.getId() +
                    " ostettu-kentän arvoksi tietokannassa " + o.getOstettu());
        }
    }
}
