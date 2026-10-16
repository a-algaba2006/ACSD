import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal2 {
    public static void main(String[] args) {
        LectorFicheros2 lector = new LectorFicheros2();

        // CASO 1: cambia "iniciales.txt" por "no_existe.txt"
        try {
            System.out.println("Caso 1 -> " + lector.leerPrimerCaracter("iniciales.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Caso 1 -> catch FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caso 1 -> catch IOException: " + e.toString());
        }

        // CASO 2: leer después de cerrar
        try {
            System.out.println("Caso 2 -> " + lector.leerTrasCerrar("iniciales.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Caso 2 -> catch FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caso 2 -> catch IOException: " + e.toString());
        }

        // CASO 3: readInt() sobre un fichero de solo 2 bytes
        try {
            System.out.println("Caso 3 -> " + lector.leerEntero("iniciales.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Caso 3 -> catch FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caso 3 -> catch IOException: " + e.toString());
        }

        // CASO 4: seek con posición negativa
        try {
            lector.irAPosicionNegativa("iniciales.txt");
            System.out.println("Caso 4 -> sin error");
        } catch (FileNotFoundException e) {
            System.out.println("Caso 4 -> catch FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caso 4 -> catch IOException: " + e.toString());
        }

        // CASO 5: escribir con el fichero abierto en modo "r"
        try {
            lector.escribirEnModoLectura("iniciales.txt");
            System.out.println("Caso 5 -> sin error");
        } catch (FileNotFoundException e) {
            System.out.println("Caso 5 -> catch FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caso 5 -> catch IOException: " + e.toString());
        }
    }
}