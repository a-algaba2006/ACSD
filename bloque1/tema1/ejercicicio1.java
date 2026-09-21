import java.io.File;
import java.io.IOException;

public class ejercicicio1 {
    public static void main(String[] args) {

        try {

        File fichero = new File("./bloque1/tema1/crearFichero.txt");
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado: " + fichero.getName());
        } else {
            System.out.println("El fichero esta creado");
        }
            
        } catch (IOException ioe) {
            System.out.println("error: " + ioe.getMessage());
        }catch(Exception e) {
            System.out.println("Error desconocido" + e.getMessage());
        }
    }
}