package servicios.task;

import com.jayway.jsonpath.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


public class Task_JsonRetornarNodo implements Task {
    private String json;
    private String jsonPath;

    private Object value;
    private String variable;
    public Task_JsonRetornarNodo(String json, String jsonPath, String variable) {
        this.json = json;
        this.jsonPath = jsonPath;
        this.variable = variable;
    }
    public static Task_JsonRetornarNodo desde(String json, String jsonPath,String variable) {
        return new Task_JsonRetornarNodo(json, jsonPath,variable);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        value = JsonPath.read(json, jsonPath);
        actor.remember(variable,value);
        actor.should("La variable "+variable+ " : "+value);
    }
    public Object getValue() {
        return value;
    }
}
