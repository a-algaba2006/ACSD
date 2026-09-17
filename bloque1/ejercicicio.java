import java.io.File;

public class ejercicicio {
    public static void main(String[] args) {

        try {

        File fichero = new File(".\\ACSD\\bloque1\\crearFichero.txt");
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado: " + fichero.getName());
        } else {
            System.out.println("El fichero ya existe.");
        }
            
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }
}