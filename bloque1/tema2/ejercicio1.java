import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class ejercicio1 {
    public static void main(String[] args) {

        try {

            LineNumberReader ln = new LineNumberReader(new FileReader("../tema2/entrada.txt"));

            String linea;

            while ((linea = ln.readLine()) != null)  {

            int palabras = 0;
            int numeros = 0;

            StreamTokenizer st = new StreamTokenizer(new StringReader(linea));

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_WORD) {
                    palabras ++;
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    numeros ++;
                }
            }

            System.out.print("Linea " + ln.getLineNumber() + ": " + linea + " ");
            System.out.println("Palabras: " + palabras + ", Numeros: " + numeros);

            }

            ln.close();

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}