package servicios.task;



import servicios.recurso.rutas.Serv_RetonarConfig;

import java.util.HashMap;

public class Task_JsonDisenoServicio {

    Serv_RetonarConfig dat_retonarconfig;
    HashMap<String, String> infoServicio;
    public void InstanciasBasicas(){
        dat_retonarconfig = new Serv_RetonarConfig();
    }
    public HashMap GetLLenarInformacionServicio(String archivoConfiguracion){
        //retornarInformacion
        InstanciasBasicas();
     //   String appid = dat_retonarconfig.retornarDatos("app-id",archivoConfiguracion);
        String urlService  =dat_retonarconfig.retornarDatos("urlBase","Serv_general");

        String appid  =dat_retonarconfig.retornarDatos("appid","Serv_general");

        String tipoServicio  =dat_retonarconfig.retornarDatos("tipoServicio",archivoConfiguracion);
        String urlapi  =dat_retonarconfig.retornarDatos("urlBase",archivoConfiguracion);
        //crearHasMap
        infoServicio=new HashMap<String,String>();
     //   infoServicio.put("app-id",appid);

        infoServicio.put("UrlBase",urlService);

        infoServicio.put("appid",appid);
        infoServicio.put("tipoServicio",tipoServicio);
        infoServicio.put("urlapi",urlapi);
        return infoServicio;

    }
}
