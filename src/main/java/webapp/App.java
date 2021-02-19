package webapp;

import dao.Admin;
//import dao.Shifts;
import org.jdbi.v3.core.Jdbi;
import services.AdminQueries;
import services.AdminService;
//import services.ShiftQueries;
//import services.ShiftService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.net.URI;
import java.net.URISyntaxException;

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

    static Jdbi getDatabaseConnection() throws URISyntaxException {
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

        return Jdbi.create("jdbc:postgresql://localhost/waiters?user=codex&password=1234");

    }

    public static void main(String[] args) {
        try {

            staticFileLocation("/public");
            Jdbi jdbi = getDatabaseConnection();
            port(getHerokuAssignedPort());
            Admin adminServices = new AdminService(new AdminQueries(jdbi));
//            Shifts waiterService = new ShiftService(new ShiftQueries(jdbi));

            get("/", (req, res) -> {
                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "index.handlebars");
            }, new HandlebarsTemplateEngine());

            get("/waiters/:username", (req, res) -> {
                Map<String, String> dataMap = new HashMap<>();

                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

            post("/waiters/:username", (req, res) -> {
                Map<String, String> dataMap = new HashMap<>();


                String username = req.queryParams("username");


                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

            post("/days", (req, res) -> {
                Map<String, Object> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

            post("/reset", (req, res) -> {
               adminServices.clearShifts();
               return  null;
            }, new HandlebarsTemplateEngine());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
