import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class ejercicio3 {
    public static void main(String[] args) {
        
        try {

            LineNumberReader ln = new LineNumberReader(new FileReader("../tema2/productos.txt"));

            String linea;

            double resultado = 0;

            System.out.println("---------- ticket de la compra ------------");
            while ((linea = ln.readLine()) != null) {
                
                System.out.println(linea);

                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));
                
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_NUMBER) {
                        resultado = st.ttype + st.ttype;
                    }
                }
            }
            
            System.out.println( + resultado);

        } catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
        }
    }
}
