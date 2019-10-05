package controladores;

import clases.Cita;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ControladorCitas {
    
    public void BorrarCita(String de, String mensaje) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Cita c = new Cita(de, mensaje);
        c.pasarCita();
    }
    
}
