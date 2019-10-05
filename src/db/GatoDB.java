package db;

import clases.Gato;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import servicios.ConectarServicio;
import servicios.Conexion;
import servicios.ConexionImagen;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class GatoDB {
    
    private Gato g;
    private int existe;
    
    public GatoDB(Gato g){
        this.g = g;
    }
    
    public void GrabarGato() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT codigoQR FROM gatos WHERE codigoQR='"+g.getCodigoQR()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            Connection con = ConexionImagen.conectar();
            String insert = "INSERT INTO gatos (nomMasc, codigoQR, nomProp, emailDue, numTel, direProp, edoReg, vet, imagen, esteril) VALUES (?,?,?,?,?,?,?,?,?,?);";
            FileInputStream fi = null; //sirve para leer la ruta de la imagen
            PreparedStatement ps = null;//Consulta
            try {
                File file = new File(g.getImagen()); //aca lee la ruta que le paso por parametro
                fi = new FileInputStream(file); //lee la imagen.
                //pasamo todos los datos a los ?
                ps = con.prepareStatement(insert);
                ps.setString(1, g.getNomMasc());
                ps.setString(2, g.getCodigoQR());
                ps.setString(3, g.getNomProp());
                ps.setString(4, g.getEmailDue());
                ps.setString(5, g.getNumTel());
                ps.setString(6, g.getDireProp());
                ps.setString(7, g.getEdoReg());
                ps.setString(8, g.getVet());
                ps.setBinaryStream(9, fi);
                ps.setString(10, "No");
                ps.executeUpdate();     
                JOptionPane.showMessageDialog(null, "El gato se añadio exitosamente");   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Porfavor inserta una imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar al gato (Desde la clase GatoDB)", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void ModificarVacunas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT codigoQR FROM gatos WHERE codigoQR='"+g.getCodigoQR()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                cdb.un_sql = "UPDATE gatos SET rabia='"+g.getRabia()+"', leu='"+g.getLeu()+
                        "', calic='"+g.getCalic()+"', panle='"+g.getPanle()+"', rino='"+g.getRino()+"', esteril='"+g.getEsteril()+
                        "', comentarios='"+g.getComentarios()+"' WHERE codigoQR='"+g.getCodigoQR()+"';";
                cdb.us_st.executeUpdate(cdb.un_sql);
                JOptionPane.showMessageDialog(null, "Las vacunas se han guardado/actualizado correctamente!");
            }else{
                JOptionPane.showMessageDialog(null, "No has ingresado un QR existente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La busqueda del codigo ha devuelto un codigo Null");
        }
    }
    
    public int VerificarCodigo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT * FROM chips WHERE codigo='"+g.getCodigoQR()+"' AND activo='0';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                existe=1;
                cdb.un_sql = "UPDATE chips SET activo='1' WHERE codigo='"+g.getCodigoQR()+"';";
                cdb.us_st.executeUpdate(cdb.un_sql);
            }else{
                existe=0;
            }
        }
        return existe;
    }
}
