package waiter;

import dao.DaysDao;
import daoImple.DaysImple;
import model.dao.Day;
import org.jdbi.v3.core.Jdbi;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import waiter.admin.Admin;
import waiter.days.Days;
import waiter.maps.DaysMap;
import waiter.person.Register.Register;
import waiter.person.Waiters;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
private static DaysDao daysDao;

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
            Jdbi jdbi = getDatabaseConnection("jdbc:postgresql://localhost/waiters?user=codex&password=1234");
            daysDao = new DaysImple(jdbi);
            staticFileLocation("/public");
            staticFileLocation("/templates");
            port(getHerokuAssignedPort());
            Waiters waiters = new Waiters(jdbi);
            Days days = new Days();
            //Login login = new Login(jdbi);
            Admin admin = new Admin(jdbi);
            get("/", (req, res) -> {

                Map<String, String> dataMap = new HashMap<>();
                //  res.redirect("/waiter.Login");
//
                return new ModelAndView(dataMap, "login.handlebars");
            }, new HandlebarsTemplateEngine());


            get("/register", (req, res) -> {
                String firstName = req.queryParams("firstName");
                String lastName = req.queryParams("lastName");
                String Password = req.queryParams("password");
                String ConfirmPassword = req.queryParams("ConfirmPassword");

                Register register = new Register();

                register.setFirstName(firstName);
                register.setLastName(lastName);
                register.setPassword(Password);
                register.setConfirmPassword(ConfirmPassword);

                register.getFirstName();
                register.getLastname();
                register.getPassword();
                register.getConfirmPassword();

                jdbi.useHandle(h -> {
                    h.execute("insert into UserName (firstName, lastName,Password,ConfirmPassword) values (?, ?,?,?)",
                            firstName,
                            lastName,
                            Password,
                            ConfirmPassword
                    );
                    if (Password == null) {
                        res.body("enter password");
                    } else if (!Password.equals(ConfirmPassword)) {
                        res.body("password don't match");
                    }
                });
                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "register.handlebars");
            }, new HandlebarsTemplateEngine());

            get("/login", (req, res) -> {
//                System.out.println("check");
                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

//            get("/signIn", (req, res) -> {
//                String username = req.queryParams("username");
//                String password = req.queryParams("password");
//
//                Login userLogin = new Login();
//
//                userLogin.setUsername(username);
//                userLogin.setPassword(password);
//
//                userLogin.getUsername();
//                userLogin.getPassword();
//
//                jdbi.useHandle(h -> {
//                    h.execute("insert into login (username,Password) values (?,?)",
//                            username,
//                            password
//                    );
////                    if (username == null) {
////                        res.body("enter password");
////                    } else if (!password.equals(password) ) {
////                        res.body("password don't match");
////                    }
//                });

//                Map<String, String> dataMap = new HashMap<>();
//                return new ModelAndView(dataMap, "waiters.handlebars");
//            }, new HandlebarsTemplateEngine());

            get("/waiters/:username", (req, res) -> {
                String username = req.queryParams("username");

                Waiters waiter = new Waiters();

                waiter.setUser(username);
                waiter.getUser();

                jdbi.useHandle(h -> {
                    h.execute("insert into users (username) values (?)",
                            username
                    );
                });
                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

            post("/waiters/:username", (req, res) -> {
// This is to get the details for the user to be able  to login & select working days
                Map<String, String> dataMap = new HashMap<>();
                String username = req.queryParams("username");
              //  String password = req.queryParams("password");

                jdbi.useHandle(h -> {
                    h.execute("insert into users (username) values (?)",
                            username

                    );
//
                });
                //  res.redirect("/");

                return new ModelAndView(dataMap, "waiters.handlebars");
            }, new HandlebarsTemplateEngine());

            get("/admin", (req, res) -> {
                admin.setAdmin(req.params("username"));
                admin.getAdmin();

                Map<String, String> dataMap = new HashMap<>();
                return new ModelAndView(dataMap, "admin.handlebars");
            }, new HandlebarsTemplateEngine());

//            get("/waiter.Login", (req, res) -> {
//                List<Login> people = jdbi.withHandle((h) -> {
//                    List<Login> userLogin = h.createQuery("select username, password from login")
//                            .mapToBean(Login.class)
//                            .list();
//                    return userLogin;
//                });
                Map<String, Object> map = new HashMap<>();
                List<Day> daysList = daysDao.getDays();
//                System.out.println(daysList);
                map.put("daysList", daysList);
//
//                map.put("username",people);
//                map.put("password", people);


                System.out.println(map);
//                res.redirect("/");
//                return new ModelAndView(map, "waiters.handlebars");
//
//            }, new HandlebarsTemplateEngine());


//            get("/add_shift", (req, res) -> {
//                Map<String, String> dataMap = new HashMap<>();
//                Days days1 = new Days();
//                days.setDaysOfWeek(req.queryParams("daysofweek"));
//                days.getDaysOfWeek();
//                for (DaysMap day: days1.getDaysOfWeek()){
//                    System.out.println(day.getDaysInAWeek());
//                }
//
////                dataMap.put("days", days1.getDaysOfWeek());
//                return new ModelAndView(dataMap, "waiters.handlebars");
//            }, new HandlebarsTemplateEngine());

//
            post("/register", (req, res) -> {
                res.redirect("/");
                return null;
            });

//            post("/add_shift", (req, res) -> {
//                res.redirect("/add_shift");
//                return null;
//            });

//            post("/signIn", (req, res) -> {
//                System.out.println(req.queryParams("firstName"));
//                System.out.println(req.queryParams("password"));
//                res.redirect("/waiter.Login");
//                return null;
//            });



            post("/days", (req, res) -> {

                // get form data values
//
//                Days getDays =  new Days();
//
//                days.setDaysOfWeek();
//                days.getDaysOfWeek();
                String daysOfWeek = req.queryParams("daysOfWeek");
                List<Days> daysOfweek = jdbi.withHandle(h -> {
                    if (daysOfWeek == null) {
                        return new ArrayList<>();
                    }

                    if (!daysOfWeek.equals("")
                    ) {
                        return h.createQuery(
                                "select * from waiter.days.Days where Days_In_A_Week = false "
                        )
                                .bind(0, daysOfWeek)
                                .mapToBean(Days.class)
                                .list();
                    }
                    List<Days> DayList = h.createQuery(
                            "select * from waiter.days.Days where Days_In_A_Week = false "
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
   // String firstName = req.queryParams("firstName");
//                String password = req.queryParams("password");
//                System.out.println(req + " body");
//                System.out.println(firstName + " " + password);
//                System.out.println("line 78");
//                res.redirect("register.handlebars");
//                return null;


//                System.out.println(req.queryParams("firstName"));
//                System.out.println(req.queryParams("LastName"));
//                System.out.println(req.queryParams("password"));
//                System.out.println(req.queryParams("reEnterPassword"));

//
//                if ("username" == "username" && "password" == "password") {
//                    res.redirect("/waiters" + (waiters.getUser()));
//                }

//                if ("username" == "Admin" && "password" == "admin") {
//                    res.redirect("/admin");
//                }