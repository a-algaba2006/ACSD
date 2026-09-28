import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);

        boolean continuar = true;
        
        try {

            while (continuar) {
            System.out.println("Bienvenido al sistema de gestion de matriculas del alumnado, por favor, eliga estas 3 opciones: \n1.Rellenar datos de un alumno,  \n2.Imprimmir datos de los alumnos \n3.Salir");

            int opciones = Integer.parseInt(sc.nextLine());

            switch (opciones) {
                case 1:

                System.out.print("Nombre y apellidos del alumno: ");

                String nombreApellidos  = sc.nextLine();

                System.out.print("Email del alumno: ");

                String email = sc.nextLine();

                System.out.print("Fecha de nacimiento del alumno: ");

                String fechaNac = sc.nextLine();

                System.out.print("Genero del alumno: ");

                String genero = sc.nextLine();

                System.out.print(" Titulacion de acceso del alumno: ");

                String titulacion = sc.nextLine();

                System.out.print("Observaciones: ");

                String observaciones = sc.nextLine();

                String datos = "----- Formulario de Matriculación ----- \n" + "Nombre y Apellidos: " + nombreApellidos + "\n" + "Email: " 
                + email  + "\n" + "Fecha de Nacimiento:" +  fechaNac + "\n" + "Género: " + genero  + "\n" + "Titulación de Acceso: " + titulacion + "\n" 
                + "Observaciones: " + observaciones + "\n" + "---------------------------------------" + "\n";

                FileWriter escritura = new FileWriter("../tema1/matricula.txt", true);

                escritura.write(datos);

                escritura.close();

                System.out.println("Datos del alumno guardados perfectamente");

                System.out.println(" ");
                    
                    break;

                    case 2:

                    System.out.println("Mostrando, datos de la matricula del alumnado: ");

                    FileReader lectura = new FileReader("../tema1/matricula.txt");

                    int data;

                    while ((data = lectura.read()) !=  -1) {

                        System.out.print((char)data);
                    }

                    System.out.println(" ");

                    break;

                    case 3:

                    System.out.println("Has elegido la opcion de salir, hasta pronto");
                    continuar = false;
                    break;
            
                default:
                    System.out.println("Opcion no disponible, vuelve a intentarlo");
                    break;
            }

            }
            
        } catch(NumberFormatException nfe) {
            System.out.println("Dato incorrecto, por favor introduzca un dato valido");
        } catch (Exception e) {
            System.out.println("Error deconocido: " + e.getMessage());
        }

        sc.close();
    }
}
