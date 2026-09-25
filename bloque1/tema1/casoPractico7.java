import java.io.RandomAccessFile;

public class casoPractico7 {
    public static void main(String[] args) {
        
        try {

            RandomAccessFile file = new RandomAccessFile("../tema1/abecedario.txt", "rw");

            file.seek(5);

            System.out.println("Puntero antes de read: " + file.getFilePointer());

            byte[] arrayBytes = new byte[3];

            file.read(arrayBytes, 0, 3);

            System.out.println("Bytes leidos: " + arrayBytes.length);
            System.out.println("Puntero despues de read: " + file.getFilePointer());

            for (int i = 0; i < arrayBytes.length; i++) {
                System.out.println("\n arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
            }

            file.close();
            
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
