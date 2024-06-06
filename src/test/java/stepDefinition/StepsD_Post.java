package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import servicios.recurso.rutas.Serv_RetonarConfig;
import servicios.recurso.utilidades.Ser_JsonLeerArchivo;
import servicios.task.Task_JsonDisenoServicio;
import servicios.task.Task_JsonResponse;
import servicios.task.Task_JsonRetornarNodo;
import servicios.task.Task_Serv_Ejecutar;


import java.util.HashMap;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepsD_Post {
    HashMap<String, String> infoServicio;
    Ser_JsonLeerArchivo ser_jsonLeerArchivo;

    Task_JsonDisenoServicio taskJsonDisenoServicio;

    Serv_RetonarConfig config;

    public void instanciasBasicas() {

        ser_jsonLeerArchivo = new Ser_JsonLeerArchivo();
        taskJsonDisenoServicio = new Task_JsonDisenoServicio();
        config = new Serv_RetonarConfig();

    }
    @Given("^iniciar ejecucion servicios")
    public void iniciarejecucionservicios(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("TEAM QC");
        instanciasBasicas();

    }

    @And("^ejecutar get usuarios")
    public void ejecutargetusuarios(){
        //retornar servicio original
        String rutaServicio = config.RetornarRutaServicios("Ser_01");
        String filejson = ser_jsonLeerArchivo.JsonLeerArchivo(rutaServicio);
        //modificar servicio
        //noaplica servicio get
        //traer datos servicio
        infoServicio = taskJsonDisenoServicio.GetLLenarInformacionServicio("Ser_01");
        theActorInTheSpotlight().attemptsTo(Task_Serv_Ejecutar.desde(filejson,infoServicio,"Ser_01"));
        theActorInTheSpotlight().attemptsTo(Task_JsonResponse.desde());
        //obtener valores del response
        String action = theActorInTheSpotlight().recall("response");
        theActorInTheSpotlight().attemptsTo(Task_JsonRetornarNodo.desde(action,"$.data[0].id","resultId"));
        //obtener valores del response
    }
    @And("^traer usuario")
    public void traerusuario(){
        //retornar servicio original
        String rutaServicio = config.RetornarRutaServicios("Ser_03");
        String filejson = ser_jsonLeerArchivo.JsonLeerArchivo(rutaServicio);
        //modificar servicio
        //noaplica servicio get
        //traer datos servicio
        infoServicio = taskJsonDisenoServicio.GetLLenarInformacionServicio("Ser_03");
        theActorInTheSpotlight().attemptsTo(Task_Serv_Ejecutar.desde(filejson,infoServicio,"Ser_03"));
        theActorInTheSpotlight().attemptsTo(Task_JsonResponse.desde());
        //obtener valores del response
        String action = theActorInTheSpotlight().recall("response");
        theActorInTheSpotlight().attemptsTo(Task_JsonRetornarNodo.desde(action,"$.email","correo electronico"));
        theActorInTheSpotlight().attemptsTo(Task_JsonRetornarNodo.desde(action,"$.firstName","jeisson"));
        //obtener valores del response
    }
}
