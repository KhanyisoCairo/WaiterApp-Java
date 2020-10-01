import org.jdbi.v3.core.Jdbi;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {


    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
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


    public static void main(String[] args) {

        try {
            Jdbi jdbi = getDatabaseConnection("jdbc:postgresql://localhost/waiters?user=khanyiso&password=cairo123");

            staticFileLocation("/public");
            staticFileLocation("/templates");
            port(getHerokuAssignedPort());
            Waiters waiters = new Waiters(jdbi);
            get("/", (req, res) -> {

                Map<String, String> dataMap = new HashMap<>();
                res.redirect("login.handlebars");
                return new ModelAndView(dataMap, "login.handlebars");
            }, new HandlebarsTemplateEngine());

            get("/waiters/:username", (req, res) -> {
                waiters.setUser(req.params("username"));
                waiters.getUser();
                Map<String, String> dataMap = new HashMap<>();

                return new ModelAndView(dataMap, "login.handlebars");
            }, new HandlebarsTemplateEngine());


//            get("/days", (req, res) -> {
//
//                Map<String, String> dataMap = new HashMap<>();
//
//                return new ModelAndView(dataMap, ".handlebars");
//            }, new HandlebarsTemplateEngine());


//            post("/waiters/:username", (req, res) -> {
//
//                Map<String, String> dataMap = new HashMap<>();
//
//                return new ModelAndView(dataMap, "booking.handlebars");
//            }, new HandlebarsTemplateEngine());

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
