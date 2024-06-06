package servicios.recurso.utilidades;

import com.google.gson.JsonParser;

import java.io.FileReader;

public class Ser_JsonLeerArchivo {
    public String  JsonLeerArchivo(String archivoruta) {
        String Servicio = null;
        Object obj = null;

        try{
            JsonParser parser = new JsonParser();
            obj= parser.parse(new FileReader(archivoruta));
            Servicio = obj.toString();
        }catch (Exception fallo){
            System.out.println(fallo.getMessage());
        }
        return Servicio;

    }
}
