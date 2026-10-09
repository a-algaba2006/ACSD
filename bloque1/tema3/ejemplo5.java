public class ejemplo5 {
    public static void main(String[] args) {


        try {

        int[] numeros = {1,2,3};
        System.out.println(numeros[5]);
            
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.out.println("Excepcion controlada, array fuera del limite");
        }
    }
}
