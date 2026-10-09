import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejemplo4 {
    public static void main(String[] args) throws IOException {

        try {
            FileReader fr = new FileReader("archivo.txt");

            int data;

            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();

            fr.close();
        } catch(FileNotFoundException fne) {
            System.out.println("Error de fichero no encontrado");
        }
        catch (IOException ioe) {
            System.out.println("Error de entrada y salida");
        }
        finally{
            System.out.println("Esto se ejecuta siempre");
        }
    }
}
