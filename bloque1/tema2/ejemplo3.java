import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ejemplo3{

    public static void main(String[] args) {
    
        try {

            DataOutputStream data = new DataOutputStream(new FileOutputStream("../tema2/salida.txt"));

            data.writeInt(123);

            data.writeInt(2);

            data.writeFloat(1.69F);

            data.writeDouble(134.986);

            data.writeLong(478920987);

            data.close();

            DataInputStream lectura = new DataInputStream(new FileInputStream("../tema2/salida.txt"));

            //esto sigue un orden, si primero metes un entero lees el entero, si segundo va un string lees ese string....
            int entero1 = lectura.readInt();
            int entero2 = lectura.readInt();
            float numeroFloat = lectura.readFloat();
            long numeroLong = lectura.readLong();

            double leerDouble = lectura.readDouble();

            lectura.close();

            System.out.println("el numero entero es: " + entero1 + " y " + entero2);
            System.out.println("El decimal es: " + numeroFloat + " y " + leerDouble);
            System.out.println("Long es: " + numeroLong);

            
        } catch (Exception e) {
            System.out.println("Error desconocido");
        }


    }

}