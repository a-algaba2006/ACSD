import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        
        try {

            Scanner sc = new Scanner(System.in);

            LineNumberReader ln = new LineNumberReader(new FileReader("../tema2/entradaEj2.txt"));

            String linea;

            System.out.println("Elige una opcion numerica para ver el contenido de la linea de texto: ");

            int opcion = Integer.parseInt(sc.nextLine());

            System.out.println("Mostrando contenido de la linea: " + opcion);

            while ((linea = ln.readLine()) != null) {
                if (ln.getLineNumber() == opcion) {
                    System.out.println("Contenido de la linea " + opcion + ": " + linea);
                    break;
                }
            }
            
            ln.close();
            sc.close();
            
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}