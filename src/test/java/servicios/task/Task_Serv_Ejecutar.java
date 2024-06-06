package servicios.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.serenitybdd.screenplay.rest.interactions.Post;
import servicios.recurso.rutas.Serv_RetonarConfig;


import java.util.HashMap;

public class Task_Serv_Ejecutar implements Task {

    private String body;
    private String archivoConfiguracion;
    private HashMap<String, String> infoServicio;


    public Task_Serv_Ejecutar(String body, HashMap infoServicio, String archivoConfiguracion) {
        this.body = body;
        this.archivoConfiguracion = archivoConfiguracion;
        this.infoServicio = infoServicio;
    }
    public static Task_Serv_Ejecutar desde(String body,HashMap infoServicio,String archivoConfiguracion) {
        return new Task_Serv_Ejecutar(body,infoServicio,archivoConfiguracion);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        Serv_RetonarConfig dat_retonarconfig = new Serv_RetonarConfig();

        String urlService  =dat_retonarconfig.retornarDatos("urlBase","Serv_general");

        String appid  =dat_retonarconfig.retornarDatos("appid","Serv_general");
        String urlDinamica =null;

        String urlapi  =dat_retonarconfig.retornarDatos("urlBase",archivoConfiguracion);
        String tipoServicio  =dat_retonarconfig.retornarDatos("tipoServicio",archivoConfiguracion);



        String finalUrl = urlapi;
        actor.whoCan(CallAnApi.at(urlService));
        switch (tipoServicio){
            case "get":

                actor.attemptsTo(
                        Get.resource(finalUrl).
                                with(request ->
                                        request.contentType("application/json; charset=utf-8").headers("app-id",infoServicio.get("appid").toString())
                                )
                );
                break;
            case "post":
                actor.attemptsTo(
                        Post.to(finalUrl).
                                with(request ->
                                        request.contentType("application/json; charset=utf-8")
                                                .body(body).contentType("application/json; charset=utf-8")
                                )
                );
                break;
            case "patch":
                actor.attemptsTo(
                        Patch.to(finalUrl).
                                with(request ->
                                        request.contentType("application/json; charset=utf-8")
                                                .body(body).contentType("application/json; charset=utf-8")
                                )
                );
                break;
        }

    }

}
