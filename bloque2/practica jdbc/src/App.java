import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

    private static final String url = "jdbc:mysql://localhost:3306/gimnasio"; 
    private static final String usuario = "Usuario-local";
    private static final String password = "Med@c";
   
    public static void main(String[] args) throws Exception {

         Scanner sc = new Scanner(System.in);
         boolean continuar = true;
         
        
        try (Connection con = DriverManager.getConnection(url, usuario, password);
            Statement st = con.createStatement();) {

                    while (continuar) {

                        try {
                            System.out.println("Elige opcion: ");
                            System.out.println("1.Mostrar datos de los socios");
                            System.out.println("2.Actualizar ciudad del socio");
                            System.out.println("3.eliminar monitor");
                            System.out.println("4.insertar actividad");
                            System.out.println("5.salir");

                            int opciones = Integer.parseInt(sc.nextLine());

                            switch (opciones) {
                                case 1:
                                    System.out.println("Has elegido la opcion 1");
                                    
                                    mostrarDatos(st);
                                    break;

                                case 2:
                                System.out.println("Has elegido la opcion 2");

                                System.out.println("id del socio");

                                int idSocio = Integer.parseInt(sc.nextLine());

                                System.out.println("Nuevo nombre de la ciudad");

                                String nuevaCiudad = sc.nextLine();

                                actualizarCiudad(con, idSocio, nuevaCiudad);

                                break;

                                case 3:
                                    System.out.println("Has elegido la opcion 3");

                                    System.out.println("pon el id del monitor");
                                    int idMonitor = Integer.parseInt(sc.nextLine());

                                    eliminarMonitor(con, idMonitor);

                                break;

                                case 4:
                                    System.out.println("Has elegido la opcion 4");

                                    System.out.println("pon el nombre de la actividad");
                                    String nombreActividad = sc.nextLine();

                                    System.out.println("pon el precio de la actividad");
                                    double precio = Double.parseDouble(sc.nextLine());

                                    System.out.println("pon el numero de plazas disponibles");
                                    int numPlazas = Integer.parseInt(sc.nextLine());

                                    System.out.println("pon el dia de la semana correspondiente a esta actividad");
                                    String nombreDia = sc.nextLine();

                                    System.out.println("pon el id del monitor que impartira esta actividad");
                                    int monitor = Integer.parseInt(sc.nextLine());

                                    insertarActividad(con, nombreActividad, precio, numPlazas, nombreDia, monitor);

                                break;

                                    case 5:
                                        continuar = false;
                                        System.out.println("Hasta luego");
                                    break;
                            
                                default:

                                break;
                            }
                            
                        } catch(SQLException sqle) {
                            sqle.printStackTrace();
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                    }
                    

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        sc.close();
    }


    static void mostrarDatos(Statement st) throws SQLException {
        String sql =  "select id_socio, nombre, ciudad, email, fecha_alta, telefono from socio" ;
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Datos del socio: " + rs.getInt("id_socio") + " - " + rs.getString("nombre") + " - " + rs.getString("ciudad") + " - " + rs.getString("email") + " - " + rs.getString("fecha_alta") + " - " + rs.getString("telefono"));
        }
    }

    static void actualizarCiudad(Connection con, int idSocio , String ciudad) throws SQLException {
        String sql = "update socio set ciudad = ? where id_socio = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, ciudad);
        ps.setInt(2, idSocio);

        System.out.println("Actualizado: " + ps.executeUpdate() + " fila(s)");

    }

    static void eliminarMonitor(Connection con, int idMonitor) throws SQLException {
        String sql = "delete from monitor where id_monitor = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idMonitor);

        System.out.println("Borrado: " + ps.executeUpdate() + " fila(s)");

    }

    static void insertarActividad(Connection con, String nombre, double precio, int plazas, String dia, int idMonitor) throws SQLException {
        String sql = "insert into actividad(nombre, precio, plazas, dia, id_monitor) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, nombre);
        ps.setDouble(2, precio);
        ps.setInt(3, plazas);
        ps.setString(4, dia);
        ps.setInt(5, idMonitor);
        
        System.out.println("Insertado: " + ps.executeUpdate() + " fila(s)");
    }


}
