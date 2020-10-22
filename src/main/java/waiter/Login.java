package waiter;

import org.jdbi.v3.core.Jdbi;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Login {
    public String username;
    public int password;

    public Login(String username, int password) throws URISyntaxException, SQLException {
    }

    static Jdbi getDatabaseConnection(String defualtJdbcUrl) throws URISyntaxException, SQLException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String database_url = processBuilder.environment().get("DATABASE_URL");
        String local = processBuilder.environment().get("LOCAL");
        if (local == null && database_url != null) {

            URI uri = new URI(database_url);
            String[] hostParts = uri.getUserInfo().split(":");
            String username = hostParts[0];
            String password = hostParts[1];
            String host = uri.getHost();

            int port = uri.getPort();

            String path = uri.getPath();
            String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);

            return Jdbi.create(url, username, password);

        } else if (local != null && database_url != null) {
            return Jdbi.create(database_url);
        }

        return Jdbi.create(defualtJdbcUrl);

    }

    Jdbi jdbi = getDatabaseConnection("jdbc:postgresql://localhost/waiters?user=khanyiso&password=cairo123");


    public int getPassword() {
        jdbi.withHandle(handle -> handle.createUpdate(""));
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
