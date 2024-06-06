package servicios.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class Task_JsonResponse implements Task {
    public Task_JsonResponse() {
    }
    public static Task_JsonResponse desde() {
        return new Task_JsonResponse();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        JsonParser parser = new JsonParser();
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String responce = LastResponse.received().answeredBy(actor).asString();
        JsonElement el = parser.parse(responce);
        actor.remember("response",gson.toJson(el));
        // return gson.toJson(el);
    }
}
