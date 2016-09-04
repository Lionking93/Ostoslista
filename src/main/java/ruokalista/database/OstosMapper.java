package ruokalista.database;

import org.springframework.jdbc.core.RowMapper;
import ruokalista.wrappers.Ostos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OstosMapper implements RowMapper<Ostos> {
    public Ostos mapRow(ResultSet resultSet, int rivinNro) throws SQLException {
        Ostos ostos = new Ostos();
        ostos.setId(resultSet.getInt("id"));
        ostos.setNimi(resultSet.getString("nimi"));
        ostos.setMaara(resultSet.getInt("maara"));
        ostos.setYksikko(resultSet.getString("yksikko"));
        ostos.setOstettu(resultSet.getBoolean("ostettu"));
        return ostos;
    }
}
