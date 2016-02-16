import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("tasks", request.session().attribute("tasks"));
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/result", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<Task> tasks = request.session().attribute("tasks");

      if (tasks == null) {
        tasks = new ArrayList<Task>();
        request.session().attribute("tasks", tasks);
      }

      String description = request.queryParams("description");
      Task newTask = new Task(description);

      tasks.add(newTask);

      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/result", (request, response) -> {
    //   String textInput = request.queryParams("textInput");
    //
    //   //call business logic functions here
    //   String result = textInput;
    //
    //   HashMap model = new HashMap();
    //   model.put("template", "templates/output.vtl");
    //   model.put("result", String.format(result));
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
      //additional pages would go here
  }

  //public static 'Returntype' 'FuncName' (Paramtype param) {}  //first business logic function

}
