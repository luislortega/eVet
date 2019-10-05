package db;

import clases.Cita;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import servicios.ConectarServicio;
import servicios.Conexion;

/**
 * @author Luis Gerardo Leon Ortega
 */

public class CitasDB {
    
    Cita c;
    
    public CitasDB(Cita c){
        this.c = c;
    }
    
    public void EliminarCita() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "DELETE FROM citas WHERE de='"+c.getDe()+"' AND mensaje='"+c.getMensaje()+"';";
        cdb.us_st.executeUpdate(cdb.un_sql);
        JOptionPane.showMessageDialog(null, "Cita borrada exitosamente!");
    }
    
}
