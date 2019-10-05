package clases;

import db.VersionDB;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */
public class Version {
    
    private String version;
    
    public Version(String version){
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public int PasarVersion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        VersionDB vdb = new VersionDB(this);
        return vdb.VerificarVersion();
    }
}
