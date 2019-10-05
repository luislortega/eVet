package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ControladorImagen {
    
    public Connection conectar(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/perros";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","1298");
            System.out.println("conexion a la base de datos exitosa (Imagen)");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar (Imagen)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con; 
    }
}
