package servicios.recurso.utilidades;

import java.io.*;
import java.util.Properties;

public class Serv_ModificarProperties {
    public  void modificar(String rutaArchivo, String clave, String valor) {
        try (InputStream entrada = new FileInputStream(rutaArchivo)) {
            Properties propiedades = new Properties();

            // Cargar el archivo de propiedades existente
            propiedades.load(entrada);

            // Modificar la propiedad deseada
            propiedades.setProperty(clave, valor);

            // Guardar los cambios en el archivo
            try (OutputStream salida = new FileOutputStream(rutaArchivo)) {
                propiedades.store(salida, null);
            }

            System.out.println("Archivo de propiedades modificado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
