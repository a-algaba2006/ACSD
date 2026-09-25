import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        
        try {

            FileReader lectura = new FileReader("../tema1/asientos.txt");

            int datos;

            System.out.println("Informacion de los asientos: ");
            while ((datos = lectura.read()) != -1) {
                System.out.print((char) datos);
            }

            lectura.close();

            boolean continuar = true;
            Scanner sc = new Scanner(System.in);

            //Estructura del bucle

            while (continuar) {

            try {

            System.out.print("Bienvenido al sistema de reserva de asientos, elige estas dos opciones, 1.Elegir asiento, 2.salir");

                int opciones = Integer.parseInt(sc.nextLine());

                switch (opciones) {
                    case 1:
                        System.out.println("Elige un asiento que este disponinble");
                        
                        break;

                        case 2:
                        System.out.println("Has elegido salir, hasta pronto");
                        continuar = false;
                        break;
                
                    default:
                        System.out.println("Opcion elegida incorrecta o no disponible");
                        break;
                }

                //final del catch
            } catch (NumberFormatException nfe) {
                System.out.println("Parametro introducido incorrecto " + nfe.getMessage());
            } catch(Exception e) {
                System.out.println("Error desconocido: " + e.getMessage());
            }

        }
            
        sc.close();
            
        } catch (IOException ioe) {
            System.out.println("Error de lectura/escritura de fichero: " + ioe.getMessage());
        } catch(Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
