package ruokalista.utility;

import org.springframework.stereotype.Component;

@Component
public class UrlParser {

    private String[] urlArray;

    public String getUsername() {
        String username = this.urlArray[1].substring(2);
        return username;
    }

    public String getPassword() {
        String passwordAndHost = this.urlArray[2];
        String password = passwordAndHost.split("@")[0];
        return password;
    }

    public String getHost() {
        String passwordAndHost = this.urlArray[2];
        String host = passwordAndHost.split("@")[1];
        return host;
    }

    public String getPort() {
        String portAndDatabaseName = this.urlArray[3];
        String port = portAndDatabaseName.split("/")[0];
        return port;
    }

    public String getDatabaseName() {
        String portAndDatabaseName = this.urlArray[3];
        String databaseName = portAndDatabaseName.split("/")[1];
        return databaseName;
    }

    public String getJdbcPostgreSqlUrl() {
        String jdbcUrl = "jdbc:postgresql://" + getHost() + ":" + getPort() +
                "/" + getDatabaseName();
        return jdbcUrl;
    }

    public void setUrlToBeParsed(String pUrl) {
        this.urlArray = pUrl.split(":");
    }
}
