import java.io.FileReader;
import java.io.StreamTokenizer;

public class ejemplo1 {
    
    public static void main(String[] args) {

    try {

    StreamTokenizer st = new StreamTokenizer(new FileReader("../tema2/ejemplo.txt"));
    //configurar para q el caracter de nueva linea interpretada
    st.eolIsSignificant(true);
    int palabras = 0;
    int numeros = 0;
    while (st.nextToken() != StreamTokenizer.TT_EOF) {
    if (st.ttype == StreamTokenizer.TT_WORD) {
        System.out.println("Palabra: " + st.sval);// token de tipo palabra
        palabras ++;
    } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
        System.out.println("Numero: " + st.nval);// token de tipo número
        numeros ++;
    } else if (st.ttype == StreamTokenizer.TT_EOL) {
        System.out.println("Salto de linea");// fin de línea
    }
}

System.out.println("Hay " + palabras + " palabras y " + numeros + " numeros");

        } catch (Exception e) {
            System.out.println("error desconocido: " + e.getMessage());
        }
    }
}
