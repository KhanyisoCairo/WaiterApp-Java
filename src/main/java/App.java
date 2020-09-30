import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        staticFileLocation("/templates");

        get("/", (req, res) -> {

            Map<String, String> dataMap = new HashMap<>();

            return new ModelAndView(dataMap, "logIn.handlebars");
        }, new HandlebarsTemplateEngine());
    }

}
