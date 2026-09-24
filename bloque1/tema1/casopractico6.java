import java.io.RandomAccessFile;

public class casopractico6 {

    public static void main(String[] args) {
        
        try {

            RandomAccessFile file = new RandomAccessFile("../tema1/abecedario.txt", "rw");
            file.seek(5);

            System.out.println("Puntero antes de leer: " + file.getFilePointer());

            int unbyte = file.read(); //lee via codigo ASCII, importante, lee la posicioon indicada(seek) y a partir de esa posicion, mueve el cursos un nivel mas

            System.out.println("Puntero despues de leer:");
            System.out.println((char) unbyte);

            file.write('9');

            file.close();

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}