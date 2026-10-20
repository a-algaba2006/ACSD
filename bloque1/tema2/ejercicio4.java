import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class ejercicio4 {
    public static void main(String[] args) {
        
        try {

           LineNumberReader lectura = new LineNumberReader(new FileReader("../tema2/servidor.log"));

           String linea;
           int errores = 0;

           while ((linea = lectura.readLine()) != null) {
                if (linea.contains("ERROR")) {
                    errores++;
                    System.out.println(linea);
                }
           }

           
           System.out.println("Numero de errores: " + errores);

           lectura.close();
            
        }catch (IOException ioe) {
            System.out.println("Error de lectura/escritura: " + ioe.getMessage());
        }
         catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
