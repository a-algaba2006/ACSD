import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LectorFicheros2 {

    // 1. Abrir y leer: puede fallar al ABRIR (FileNotFoundException)
    public int leerPrimerCaracter(String ruta) throws IOException {
        try (FileReader fr = new FileReader(ruta)) {
            return fr.read();
        }
    }

    // 2. Leer un fichero que ya se ha cerrado
    public int leerTrasCerrar(String ruta) throws IOException {
        FileReader fr = new FileReader(ruta);
        fr.close();
        return fr.read();
    }

    // 3. Pedir un int (4 bytes) a un fichero que tiene menos
    public int leerEntero(String ruta) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(ruta))) {
            return in.readInt();
        }
    }

    // 4. Posicionarse en una posición negativa
    public void irAPosicionNegativa(String ruta) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            raf.seek(-1);
        }
    }

    // 5. Escribir en un fichero abierto solo para leer
    public void escribirEnModoLectura(String ruta) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            raf.write('X');
        }
    }
}