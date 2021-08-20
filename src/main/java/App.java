import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        post("/heroes/new", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("hero");
            String power = request.queryParams("power");
            String weakness= request.queryParams("weakness");
            int age = Integer.parseInt(request.queryParams("age"));
            Hero newHero = new Hero(name,age,power,weakness,1);
            model.put("hero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/squads/new", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("squad");
            int SquadId = Squad.getSquadId();
            Squad newSquad = new Squad(SquadId,name);
            model.put("squad", newSquad);
            return new ModelAndView(model, "Squad-detail.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params(":id")); //pull id - must match route segment
            Hero foundHero = Hero.findById( idOfHeroToFind); //use it to find post
            model.put("hero", foundHero); //add it to model for template to display
            return new ModelAndView(model, "hero-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
}
}
