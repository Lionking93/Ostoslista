package ruokalista.config;

import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import ruokalista.utility.UrlParser;

@Configuration
@PropertySource("application.properties")
public class DatabaseConfig {

    @Autowired
    private Environment env;

    @Autowired
    private UrlParser urlParser;

    public DatabaseConfig(UrlParser pUrlParser) {
        this.urlParser = pUrlParser;
    }

    @Bean
    public SimpleDriverDataSource dataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriver(new Driver());
        try {
            String dbUrl = env.getRequiredProperty("db.url");
            this.urlParser.setUrlToBeParsed(dbUrl);
            simpleDriverDataSource.setUrl(this.urlParser.getJdbcPostgreSqlUrl());
            simpleDriverDataSource.setUsername(this.urlParser.getUsername());
            simpleDriverDataSource.setPassword(this.urlParser.getPassword());
        } catch (NullPointerException e) {
            System.out.println("Ympäristömuuttujaa ei ole asetettu!");
        }
        return simpleDriverDataSource;
    }
}
