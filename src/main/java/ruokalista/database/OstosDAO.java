package ruokalista.database;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import ruokalista.wrappers.Ostos;

import java.util.List;

public interface OstosDAO {

    /**
     * Tietokantayhteyden alustus
     */
    public void setDataSource(SimpleDriverDataSource ds);

    /**
     * Ostoksen tallentaminen tietokantaan
     */
    public void tallennaOstos(Ostos ostos);

    /**
     * Kaikkien ostosten haku
     * @return Lista Ostos-olioita
     */
    public List<Ostos> haeOstokset();

    /**
     * Ostosten ostettu-tilan muutos
     */
    public void merkitseOstoksiaOstetuiksi(List<Ostos> ostokset);
}
