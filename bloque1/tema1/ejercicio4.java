import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ejercicio4 {
    public static void main(String[] args) {
        
        try {

            //Abrir el archivo en modo lectura
             BufferedInputStream entrada = new BufferedInputStream(new FileInputStream("../tema1/foto.jpg"));

             //Abrir el archivo en modo escritura
             BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream("../tema1/foto_copia_buffer.jpg"));

            //Definir buffer de lectura y escritura se sigue siempre esta estructura, despues de crear los buffers de operaciones I/O, se define el tamaño en bytes con un array
            //Y establecemos una variable int para el bucle, q pueda guardar los datos leidos y a partir de esa variable construir(o escribir) el archivo necesario con los bytes especificados
            byte[] bufferSize = new byte[1024];
             int bytesLeidos;

             //Le decimos al bucle, lee los archivos de entrada con el tamaño de bytes establecido y guardalos en bytesLeidos, mientras NO de -1 al extraer los bytes de la imagen (-1 significa q ya no hay nada)
             while ((bytesLeidos = entrada.read(bufferSize)) != -1) {
                salida.write(bufferSize, 0, bytesLeidos); //y mientras el bucle guarda informacion, se escribe especificando el tamaño de bytes q se traeran al escribir, por donde debe empezar a escribir(siempre desde la posicion 0), y indicamos el tamaño real q trae el tamaño para construir
             }

             entrada.close();
             salida.close();
            
        } catch (Exception e) {
           System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
