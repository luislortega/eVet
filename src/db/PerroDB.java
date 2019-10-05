package db;

import clases.Perro;
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

public class PerroDB {
    
    private Perro p;
    private int existe;
    
    public PerroDB(Perro p){
        this.p = p;
    }
    
    public void GrabarPerro() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT codigoQR FROM perros WHERE codigoQR='"+p.getCodigoQR()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);   
        if (cdb.resultado != null) {
            Connection con = ConexionImagen.conectar();
            String insert = "INSERT INTO perros (nomMasc, codigoQR, nomProp, emailDue, numTel, direProp, edoReg, vet, imagen, esteril) VALUES (?,?,?,?,?,?,?,?,?,?);";
            FileInputStream fi = null; //sirve para leer la ruta de la imagen
            PreparedStatement ps = null;//Consulta
            try {
                File file = new File(p.getImagen()); //aca lee la ruta que le paso por parametro
                fi = new FileInputStream(file); //lee la imagen.
                //pasamo todos los datos a los ?
                ps = con.prepareStatement(insert);
                ps.setString(1, p.getNomMasc());
                ps.setString(2, p.getCodigoQR());
                ps.setString(3, p.getNomProp());
                ps.setString(4, p.getEmailDue());
                ps.setString(5, p.getNumTel());
                ps.setString(6, p.getDireProp());
                ps.setString(7, p.getEdoReg());
                ps.setString(8, p.getVet());
                ps.setBinaryStream(9, fi);
                ps.setString(10, "No");
                ps.executeUpdate();     
                JOptionPane.showMessageDialog(null, "El perro se añadio exitosamente");   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Porfavor inserta una imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar el perro (Desde la clase PerroDB)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ModificarVacunas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT codigoQR FROM perros WHERE codigoQR='"+p.getCodigoQR()+"';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                cdb.un_sql = "UPDATE perros SET parvo='"+p.getParvo()+"', moqui='"+p.getMoqui()+"', adeno='"+p.getAdeno()+"', rabia='"+p.getRabia()+
                        "', parain='"+p.getParain()+"', borda='"+p.getBorda()+"', leptos='"+p.getLeptos()+"', influ='"+p.getInflu()+
                        "', esteril='"+p.getEsteril()+"', comentarios='"+p.getComentarios()+"' WHERE codigoQR='"+p.getCodigoQR()+"';";
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
        cdb.un_sql = "SELECT * FROM chips WHERE codigo='"+p.getCodigoQR()+"' AND activo='0';";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                existe=1;
                cdb.un_sql = "UPDATE chips SET activo='1', fecha=CURDATE() WHERE codigo='"+p.getCodigoQR()+"';";
                cdb.us_st.executeUpdate(cdb.un_sql);
            }else{
                existe=0;
            }
        }
        return existe;
    }
}
