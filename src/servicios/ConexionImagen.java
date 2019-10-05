package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ConexionImagen {
    //Conexion para la imagen
    public static Connection conectar(){
        Connection con = null;
        String url = "jdbc:mysql://petlove.com.mx/petloveapp";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"usuarioAdds","142578Luis");
            System.out.println("En linea base de datos (Imagen)");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al conectar a Base de datos (Imagen)");
        }
        return con;
    }
}
