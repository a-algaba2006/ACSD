import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ejercicio2 {
    public static void main(String[] args) {

        String rutaEntrada = "./bloque1/tema1/foton.jpg";
        String rutasalida = "./bloque1/tema1/copiafoto.jpg";

        try {

            FileInputStream lectura = new FileInputStream(rutaEntrada);//guarda la ruta de entrada (lectura es decir lee la imagen)
            FileOutputStream escritura = new FileOutputStream(rutasalida);//modifica el archivo en la ruta especificadsa, salida

            int data;//para representar los numeros de bytes(binario)

            while ((data = lectura.read()) != -1) {//la misma regla, a partir del -1 no hay nada
                escritura.write(data);
            }

            lectura.close();
            escritura.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
