import java.io.IOException;

public class Principal1 {
    public static void main(String[] args) {
        LectorFicheros1 lector = new LectorFicheros1();
        try {
            System.out.println(lector.leerPrimeraLinea("mis_datos.txt"));
            System.out.println(lector.leerPrimeraLinea("no_existe.txt"));
            System.out.println("Esta línea no se ejecuta");
        } catch (IOException e) {
            System.out.println("Tratado en main -> " + e.toString());
            e.printStackTrace(System.out);
        }
        System.out.println("El programa sigue");
    }
}