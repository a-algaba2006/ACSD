public class ejemplo7 {
    public static void main(String[] args) {
        
        try {
            int a = 10;
            int b = 0;
            int resultado = a/b;
            System.out.println(resultado);
        } catch (ArithmeticException ae) {
            System.out.println("Error aritmetico");
        }
    }
}
