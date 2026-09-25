import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ejercicio5 {
    public static void main(String[] args) {

        //sin buffers
        try {

            System.out.println("Copiando una imagen pesada usando solo FileInputStream/FileOutputStream: ");

            FileInputStream entrada = new FileInputStream("../tema1/ejemplo_foto.jpg");
            FileOutputStream salida = new FileOutputStream("../tema1/ejemplo_foto_copia.jpg");

            int datos;

            while ((datos = entrada.read()) != -1) {
                salida.write(datos);
            }

            entrada.close();
            salida.close();
            
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
        

        //con Buffers
        try {

            System.out.println("Copiando una imagen pesada usando solo BufferedInputStream/BufferedOutputStream: ");

            BufferedInputStream entradaBF = new BufferedInputStream(new FileInputStream("../tema1/ejemplo_foto.jpg"));
            
            BufferedOutputStream salidaBF = new BufferedOutputStream(new FileOutputStream("../tema1/ejemplo_foto_copia_BF.jpg"));

            byte[] bytes = new byte[4096];
            int datos;

            while ((datos = entradaBF.read(bytes)) != -1) {
                salidaBF.write(bytes, 0, datos);
            }

            entradaBF.close();
            salidaBF.close();

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
