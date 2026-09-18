package tema1;

import java.io.File;

public class ejemplo2 {
    public static void main(String[] args) {

    File ficheroOrigen = new File("./bloque1/tema1/crearFichero.txt"); //llama a la ruta del fichero
    File carpeta = new File("./bloque1/tema1", "backup"); //llama a la carpeta

    carpeta.mkdirs();//crea la carpeta

    File destino = new File("./bloque1/tema1/backup/ficheroMovido.txt");//llama al fichero de destino

    if (ficheroOrigen.renameTo(destino)) {
        
    }else{
        System.out.println("El fichero no se ha podido mover");
    }

    }
}
