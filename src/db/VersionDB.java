package db;

import clases.Version;
import java.sql.SQLException;
import servicios.ConectarServicio;
import servicios.Conexion;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class VersionDB {
    
    private int activo;
    private Version v;
    
    public VersionDB(Version v){
        this.v = v;
    }
    
    public int VerificarVersion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT * FROM versiones WHERE version='"+v.getVersion()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                activo=1;
            }else{
                activo=2;
            }
        }
        return activo;
    }
    
}
