package db;

import clases.Veterinario;
import java.net.SocketException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import servicios.ConectarServicio;
import servicios.Conexion;
import servicios.ObtenerMAC;
import ui.PanelUser;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class VeterinarioDB {
    
    private Veterinario v;
    private ObtenerMAC oMac;
    private int login, licencia; //en caso de error añadir un 0.
    private String mac;
    
    public VeterinarioDB(Veterinario v){
        this.v = v;
    }
    
    public int VerificarLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
       Conexion cdb = ConectarServicio.getInstancia().getConexionDb();   
       cdb.un_sql = "SELECT * FROM veterinarios WHERE user='"+v.getUser()+"' AND pass='"+v.getPass()+"';";
       cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
       
        if (cdb.resultado != null) {
            while (cdb.resultado.next()) { 
                v.setId(cdb.resultado.getString(1)); 
                v.setUser(cdb.resultado.getString(2));
                v.setPass(cdb.resultado.getString(3));
                v.setEmail(cdb.resultado.getString(5));
                v.setEdo(cdb.resultado.getString(7));
                v.setDire(cdb.resultado.getString(8)); 
                v.setOrg(cdb.resultado.getString(9));
                v.setPosc(cdb.resultado.getString(10));
            }
        }
        switch(v.getPosc()){
            case "Dev":
            case "Adm":
                new PanelUser(v.getId(), v.getUser(),v.getPosc()).setVisible(true);
                login = 1;
                break;
            case "User":
                new PanelUser(v.getId(), v.getUser()).setVisible(true);
                login = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Este existe pero no esta disponible, contacta con el Soporte Petlover desde el sitio web", 
                " Login Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        return login;
    }
    
    public void CambiarPass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT user FROM veterinarios WHERE user='"+v.getUser()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                cdb.un_sql = "UPDATE veterinarios SET pass='"+v.getPass()+"' WHERE user='"+v.getUser()+"';";
                cdb.us_st.executeUpdate(cdb.un_sql);
                JOptionPane.showMessageDialog(null, "La contraseña se ha cambiado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Al parecer tu usuario no existe en la base de datos petlover", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tu usuario ha enviado un recordset null", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void CambiarInfo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT user FROM veterinarios WHERE user='"+v.getUser()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                cdb.un_sql = "UPDATE veterinarios SET numTel='"+v.getNumTel()+"', email='"+v.getEmail()+"', dire='"+v.getDire()
                        +"', org='"+v.getOrg()+"' WHERE user='"+v.getUser()+"';";
                cdb.us_st.executeUpdate(cdb.un_sql);
                JOptionPane.showMessageDialog(null, "Tus datos se han actualizado correctamente!");
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no se encuentra en la tabla veterinarios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La busqueda del usuario ha devuelto un valor null", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ActivarLicencia() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT * FROM licencias WHERE code='"+v.getCodLic()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                v.setLicenciaActiva(cdb.resultado.getString(4));
                if (v.getLicenciaActiva().equals("0")) {
                    //ACTUALIZO LA LICENCIA
                    cdb.un_sql = "UPDATE licencias SET id_vet='"+v.getId()+
                            "', activo='1', fecha=CURDATE(), mac='"+v.getMac()+"' WHERE code='"+v.getCodLic()+"';";
                    cdb.us_st.executeUpdate(cdb.un_sql);
                    JOptionPane.showMessageDialog(null, "Licencia activada! cierra y abre de nuevo tu cuenta");
                }else{
                    JOptionPane.showMessageDialog(null, "Esta licencia ya fue activada");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Esta licencia no existe", " Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public int VerificarLicencia() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SocketException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        oMac = new ObtenerMAC();
        mac = oMac.Agarrar();
        cdb.un_sql = "SELECT * FROM licencias WHERE id_vet='"+v.getId()+"'AND mac='"+mac+"'";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            while (cdb.resultado.next()) {                
                v.setLicencia(cdb.resultado.getString(2));
                if (v.getLicencia() == null) {
                    licencia = 0;
                }else{
                    licencia = 1;
                }
            }
        }
        return licencia;
    }
}
