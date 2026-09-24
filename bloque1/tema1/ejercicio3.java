import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        
        try {

            String ruta = "../tema1/datos.txt";
            String contenido = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            FileWriter escribirFichero = new FileWriter(ruta, true);
            escribirFichero.write(contenido);
            escribirFichero.close();

            FileReader leerFichero = new FileReader(ruta);

            int linea;

            while ((linea = leerFichero.read()) != -1) {
                System.out.print((char)linea);
            }

            System.out.println("\n Fichero leido y creado");

            leerFichero.close();
            
            System.out.println("=================================================================================");

            Scanner sc = new Scanner(System.in);

            System.out.print("Elige posicion(por numero) del archivo lo que quieres modificar: ");

            int posicion = Integer.parseInt(sc.nextLine());

            RandomAccessFile accederFichero = new RandomAccessFile(ruta, "rw"); //accedemos al fichero y elegimos la opcion de leer y escribir el fichero

            long tamanioArchivo = accederFichero.length(); //guardamos la lonfitud del archivo en una variable para hacer la comparacion

            if (posicion < 0) {
                System.out.println("Posicion introducida no permitida, no se permite introducir posicioones negativas");

                accederFichero.close();
            } else if(posicion >= tamanioArchivo) {
                System.out.println("Posicion introducida no permitida, no la posicion espeecificada es demasiado grande para lo que hay dentro del fichero");

                accederFichero.close();
            } else {

            accederFichero.seek(posicion); //accede a la posicion numerica indicada

            System.out.print("Pon solo un caracter, q sea el intercambiable: ");
            char caracter = sc.nextLine().charAt(0);

            accederFichero.write(caracter);

            System.out.println("Fichero modificado correctamente" + accederFichero.getFilePointer());

            accederFichero.close();
            }
            sc.close();

            } catch (Exception e) {
                
            System.out.println("Error desconocido: " + e.getMessage());

        }
    } 
}