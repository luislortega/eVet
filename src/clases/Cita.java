package clases;

import db.CitasDB;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class Cita {
    
    String de, mensaje;
    
    public Cita(String de, String mensaje){
        this.de = de;
        this.mensaje = mensaje;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void pasarCita() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        CitasDB cdb = new CitasDB(this);
        cdb.EliminarCita();
    }
}
