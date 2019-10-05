package controladores;

import clases.Veterinario;
import java.net.SocketException;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ControladorVeterinario { 
    
    public void EnviarLicencia(int indice, String mac, String codLic, String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Veterinario v = new Veterinario(indice, mac, codLic, id);
        v.enviarLicencia();
    }
    
    public int ConectarUsuario(String user, String pass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Veterinario v = new Veterinario(user, pass);
        return v.IniciarSesion();
    }
  
    public void CambiarContra(String user, String pass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Veterinario v = new Veterinario(user, pass);
        v.enviarPass();
    }
    
    public int BuscarLicencia(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SocketException{
        Veterinario v = new Veterinario(id);
        return v.enviarID();
    }
    
    public void CambiarInformacion(String user, String numTel, String email, String direc, String org) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Veterinario v = new Veterinario(user, numTel, email, direc, org);
        v.enviarInfo();
    }
}
