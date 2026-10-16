import java.io.FileReader;
import java.io.IOException;

public class Paso5 {
    public static void main(String[] args) {
        try (FileReader file = new FileReader("no_existe.txt")) {
            file.read();
        } catch (IOException e) {
            System.out.println("getMessage():  " + e.getMessage());
            System.out.println("getCause():    " + e.getCause());
            System.out.println("toString():    " + e);
            System.out.println("getStackTrace()[0]: " + e.getStackTrace()[0]);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}