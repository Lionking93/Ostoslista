package ruokalista.utility.utility;

import org.junit.Before;
import org.junit.Test;
import ruokalista.utility.UrlParser;

import static org.junit.Assert.assertEquals;

public class UrlParserTest {

    private UrlParser urlParser;

    @Before
    public void initializeUrlParser() {
        String databaseUrl = "postgres://kayttajanimi:salasana@127.0.0.1:5432/tietokanta";
        this.urlParser = new UrlParser();
        this.urlParser.setUrlToBeParsed(databaseUrl);
    }

    @Test
    public void urlParserReturnsCorrectUsername() {
        String username = this.urlParser.getUsername();
        assertEquals("kayttajanimi", username);
    }

    @Test
    public void urlParserReturnsCorrectPassword() {
        String password = this.urlParser.getPassword();
        assertEquals("salasana", password);
    }

    @Test
    public void urlParserReturnsHostCorrectly() {
        String host = this.urlParser.getHost();
        assertEquals("127.0.0.1", host);
    }

    @Test
    public void urlParserReturnsPortCorrectly() {
        String port = this.urlParser.getPort();
        assertEquals("5432", port);
    }

    @Test
    public void urlParserReturnDatabaseNameCorrectly() {
        String databaseName = this.urlParser.getDatabaseName();
        assertEquals("tietokanta", databaseName);
    }

    @Test
    public void urlParserReturnsJDBCUrlCorrectly() {
        String jdbcUrl = this.urlParser.getJdbcPostgreSqlUrl();
        assertEquals("jdbc:postgresql://127.0.0.1:5432/tietokanta", jdbcUrl);
    }
}
