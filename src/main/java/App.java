import org.jdbi.v3.core.Jdbi;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            Admin admin = new Admin(jdbi);
            get("/", (req, res) -> {

                Map<String, String> dataMap = new HashMap<>();
              //  res.redirect("/Login");
                return new ModelAndView(dataMap, "login.handlebars");
            }, new HandlebarsTemplateEngine());
            get("/register", (req, res) -> {

                Map<String, String> dataMap = new HashMap<>();
                //  res.redirect("/Login");
                return new ModelAndView(dataMap, "register.handlebars");
            }, new HandlebarsTemplateEngine());

            get("/waiters/:username", (req, res) -> {
                waiters.setUser(req.params("username"));
                waiters.getUser();


                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());
            get("/admin", (req, res) -> {
                admin.setAdmin(req.params("username"));
                admin.getAdmin();


                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "login.handlebars");
            }, new HandlebarsTemplateEngine());

            get("/Login", (req, res) -> {
                List<Login> people = jdbi.withHandle((h) -> {
                    List<Login> userLogin = h.createQuery("select username, password from login")
                            .mapToBean(Login.class)
                            .list();
                    return userLogin;
                });
                Map<String, Object> map = new HashMap<>();
                map.put("username", people);
                map.put("password", people);

//                res.redirect("/");
                return new ModelAndView(map, "waiters.handlebars");

            }, new HandlebarsTemplateEngine());

            get("/days", (req, res) -> {

                Map<String, String> dataMap = new HashMap<>();

                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());


            post("/waiters/:username", (req, res) -> {

                Map<String, String> dataMap = new HashMap<>();
                String username = req.queryParams("username");
                String password = req.queryParams("password");


                jdbi.useHandle(h -> {
                    h.execute("insert into login (name, password) values (?, ?)",
                            username,
                            password
                    );
                });

                //  res.redirect("/");

                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

            post("/days", (req, res) -> {

                // get form data values
                String daysOfWeek = req.queryParams("daysOfWeek");


                List<Days> daysOfweek = jdbi.withHandle(h -> {

                    if (daysOfWeek == null) {
                        return new ArrayList<>();
                    }

                    if (!daysOfWeek.equals("")
                    ) {
                        return h.createQuery(
                                "select * from Days where Days_In_A_Week = false "
                        )
                                .bind(0, daysOfWeek)
                                .mapToBean(Days.class)
                                .list();
                    }
                    List<Days> DayList = h.createQuery(
                            "select * from Days where Days_In_A_Week = false "
                    )
                            .bind(0, daysOfWeek)
                            .mapToBean(Days.class)
                            .list();

                    return DayList;

                });
                Map<String, Object> dataMap = new HashMap<>();

                return new ModelAndView(dataMap, "waiters.handlebars");

            }, new HandlebarsTemplateEngine());


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
