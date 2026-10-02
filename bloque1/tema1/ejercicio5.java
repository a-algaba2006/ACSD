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
            int contador = 0;
            long inicio1 = System.currentTimeMillis();
            while ((datos = entrada.read()) != -1) {
                salida.write(datos);
            }

            System.out.println("Se han copiado " + contador + "bytes");
            long final1 = System.currentTimeMillis();
            System.out.println("FileInputStream ha tardado " + (final1 - inicio1));

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
            int contador = 0;
            long inicio1 = System.currentTimeMillis();

            while ((datos = entradaBF.read(bytes)) != -1) {
                salidaBF.write(bytes, 0, datos);
                contador ++;
            }

            System.out.println("Se han copiado " + contador + "bytes");
            long final1 = System.currentTimeMillis();
            System.out.println("FileInputStream ha tardado " + (final1 - inicio1));

            entradaBF.close();
            salidaBF.close();

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
        //Con buffer va por bloques de bytes asi este tipo de operaciones se hace mas rapido, con file se hace byte por byte viajando al disco
    }
}
