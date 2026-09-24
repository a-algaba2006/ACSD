import java.io.RandomAccessFile;

public class casopractico6 {

    public static void main(String[] args) {
        
        try {

            RandomAccessFile file = new RandomAccessFile("C:\\Users\\PC130\\Documents\\GitHub\\2DAM\\ACSD\\bloque1\\tema1\\abecedario.txt", "rw");
            file.seek(5);

            System.out.println("Puntero antes de leer: " + file.getFilePointer());

            int unbyte = file.read(); //lee via codigo ASCII

            System.out.println("Puntero despues de leer:");
            System.out.println((char) unbyte);

            file.write('9');

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}