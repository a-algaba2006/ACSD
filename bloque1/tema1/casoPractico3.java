import java.io.File;

public class casoPractico3 {
    public static void main(String[] args) {
        String nombreCarpeta = "NuevaCarpeta";
        File carpeta = new File("./bloque1/tema1", nombreCarpeta);

        if (carpeta.exists()) {
            System.out.println("La carpeta " + carpeta.getName() + " ya existe");
        } else {
            carpeta.mkdirs();
            System.out.println("La carpeta " + carpeta.getName() + " se ha creado");
            System.out.println("Ruta absoluta " + carpeta.getAbsolutePath());
            System.out.println("Ruta relativa " + carpeta.getPath());
            System.out.println("Carpeta padre " + carpeta.getParent());
        }
    }
}
