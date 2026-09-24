import java.io.FileReader;
import java.io.FileWriter;

public class casoPractico1 {

    public static void main(String[] args) {


    try{

        FileReader lector = new FileReader("./bloque1/tema1/prueba.txt");
        FileWriter escritor = new FileWriter("./bloque1/tema1/escritura.txt");
        int data; //se debe poner como entero pq el filereader lo lee los numeros y caracteres en codigo ascii(numeros q pasan a ser caracteres)
        while ((data = lector.read()) != -1) { //le decimos a java, que mientras se ejecute la variable data guarde los caracteres de codigo ascii hasta q llegue a -1 es decir q ya no haya caracteres (-1 esq q no hay caracteres en el fichero)
            escritor.write(data);//se escribe el contenido de los datos guardados
            System.out.println((char)data);//imporime los caracteres de la variabke data guardados
        }
        
        lector.close();
        escritor.close();
        System.out.println("Lectura correcta");

    } catch(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    }
}
