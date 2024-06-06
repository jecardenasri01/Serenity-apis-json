package servicios.recurso.rutas;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Serv_RetonarConfig {
    String rutaPropiedades = "src/test/java/servicios/recurso/";
    public String retornarDatos(String dato,String entidad) {
        String archivoconfig=null;
        String datoNuevo=null;
        try{
            Properties propiedades =new Properties();
            InputStream datos =null;
            archivoconfig=RetornarRutaProperties(entidad);
            datos = new FileInputStream(archivoconfig);
            propiedades.load(datos);
            datoNuevo=   propiedades.getProperty(dato);
        }catch (Exception fallo){
            new AssertionError("No se lleno la entidad "+archivoconfig );
        }
        return datoNuevo;
    }
    public String RetornarRutaProperties(String entidad){
        String rutaconfig=null;

        switch (entidad){
            case  "Serv_general":
                rutaconfig= rutaPropiedades+"propiedades/general/"+"general.properties";
                break;
            case  "Ser_01":
                rutaconfig= rutaPropiedades+"propiedades/especifico/"+"01_Usuario.properties";
                break;
            case  "Ser_02":
                rutaconfig= rutaPropiedades+"propiedades/especifico/"+"02_CrearUsuario.properties";
                break;
            case  "Ser_03":
                rutaconfig= rutaPropiedades+"propiedades/especifico/"+"03_ObtenerUsuario.properties";
                break;

        }
        return  rutaconfig;
    }
    public String RetornarRutaServicios(String entidad){
        String rutaconfig=null;

        switch (entidad){


            case  "Ser_01":
                rutaconfig= rutaPropiedades+"estructura/"+"03_get_ResultId.json";
                break;
            case  "Az_02":
                rutaconfig= rutaPropiedades+"estructura/"+"04_patch_AddResult.json";
                break;

        }
        return  rutaconfig;
    }
}
