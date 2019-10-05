package principal;

import controladores.ControladorVersion;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JOptionPane;
import servicios.ConectarServicio;
import servicios.Conexion;
import servicios.ConexionImagen;
import ui.Login;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class Main {
    
    private static final String version = "0.05.01";
    
    public static void main(String[] args){
        try {
            FileInputStream propFile = new FileInputStream("src\\principal\\configurardb.txt");
            Properties p = new Properties(System.getProperties());
            p.load(propFile);
            System.setProperties(p);
            if (System.getProperty("mostrarpropierties").compareTo("si") == 0) {
                System.getProperties().list(System.out);
            }
        } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo");
            System.exit(-1);
        } catch(java.io.IOException w){
            JOptionPane.showMessageDialog(null, "Ocurrio un error de I/O");
            System.exit(-1);
        }
        
        try {
            Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        } catch (java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una excepcion " + e.toString());
            JOptionPane.showMessageDialog(null, "Es probable que no se puede encontrar la clase del conector jdbc " + System.getProperty("driver"));
            System.exit(-1);
        } catch (java.lang.InstantiationException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error de instanciamiento "+e.toString());
            System.exit(-1);
        } catch (java.lang.IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error de acceso ilegal "+e.toString());
            System.exit(-1);
        }
        
        try {
            ControladorVersion cv = new ControladorVersion();
            if (cv.ComprobarVersion(version) == 1) {
                Login main = new Login();
                main.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Existe una nueva version! descargala en petlover.com.mx", "MyVet", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el programa.");
        }
    }
}
