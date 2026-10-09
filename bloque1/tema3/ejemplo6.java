public class ejemplo6 {
    public static void main(String[] args) {


        try {
        String texto = null;
        long longitud = texto.length();
        System.out.println(longitud);
        } catch (NullPointerException npe) {
            System.out.println("excepcion de nullpointer exception");
        }
    }
}
