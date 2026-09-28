import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio7 {
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

                            RandomAccessFile acceso = new RandomAccessFile("../tema1/asientosEj7.txt", "rw");

                            System.out.print("Introduce el asiento de INICIO del rango: ");

                            int inicioAsientos = Integer.parseInt(sc.nextLine());

                            System.out.print("Introduce el asiento de FIN del rango: ");

                            int finAsientos = Integer.parseInt(sc.nextLine());

                            if (inicioAsientos < 0 || finAsientos >=  acceso.length() || inicioAsientos > finAsientos) {
                                System.out.println("Rango no válido o fuera de los límites del mapa de asientos.");
                                break;
                            } else {

                                boolean todoLibre  = true;

                                acceso.seek(inicioAsientos);

                                for (int i = inicioAsientos; i <= finAsientos; i++) {
                                    char estado = (char) acceso.read();
                                    if (estado == 'C') {
                                        todoLibre = false;
                                        System.out.println("Error: El asiento " + i + " ya está ocupado. No se puede reservar el rango.");
                                        break;
                                    }
                                }

                                    if (todoLibre) {
                                        acceso.seek(inicioAsientos);
                                        for (int i = inicioAsientos; i <= finAsientos; i++) {
                                            acceso.write('C');
                                        }
                                        System.out.println("¡Rango desde el asiento " + inicioAsientos + " hasta el " + finAsientos + " reservado con éxito!");
                                    }

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
