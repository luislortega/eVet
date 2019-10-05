package controladores;

import clases.Version;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ControladorVersion {
    
    public int ComprobarVersion(String version) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Version v = new Version(version);
        return v.PasarVersion();
    }
}
