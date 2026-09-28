import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {

        try {

            boolean continuar = true;
            Scanner sc = new Scanner(System.in);

            // Estructura del bucle

            while (continuar) {

                try {

                    System.out.print(
                            "Bienvenido al sistema de reserva de asientos, elige estas dos opciones, 1.Elegir asiento,2.Ver los asientos, 3.Salir: ");

                    int opciones = Integer.parseInt(sc.nextLine());

                    switch (opciones) {
                        case 1:

                            RandomAccessFile acceso = new RandomAccessFile("../tema1/asientos.txt", "rw");

                            System.out.println("Elige un asiento que este disponible");

                            long tamanioAsientos = acceso.length();

                            int posicion = Integer.parseInt(sc.nextLine());

                            char caracterLeido = acceso.readChar();

                            if (tamanioAsientos < 0 || posicion >= tamanioAsientos || caracterLeido == 'C') {
                                System.out.println("Posicion de asiento no disponible");
                            } else {

                                acceso.seek(posicion);

                                acceso.write('C');

                                System.out.println("Asiento reservado correctamente");

                            }

                            acceso.close();

                            break;

                        case 2:

                            FileReader lectura = new FileReader("../tema1/asientos.txt");

                            int datos;

                            System.out.println("Informacion de los asientos: ");
                            while ((datos = lectura.read()) != -1) {
                                System.out.print((char) datos);
                            }

                            System.out.println("Informacion de los asientos: ");
                            while ((datos = lectura.read()) != -1) {
                                System.out.print((char) datos);
                            }

                            lectura.close();

                            break;

                        case 3:
                            System.out.println("Has elegido salir, hasta pronto");
                            continuar = false;
                            break;

                        default:
                            System.out.println("Opcion elegida incorrecta o no disponible");
                            break;
                    }

                    // final del catch
                } catch (NumberFormatException nfe) {
                    System.out.println("Parametro introducido incorrecto " + nfe.getMessage());
                } catch (Exception e) {
                    System.out.println("Error desconocido: " + e.getMessage());
                }

            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
