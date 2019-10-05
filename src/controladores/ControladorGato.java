package controladores;

import clases.Gato;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ControladorGato {
    
    public void agregarGato(String nomMasc, 
                             String codigoQR, 
                             String nomProp, 
                             String emailDue, 
                             String numTel, 
                             String direProp, 
                             String edoReg,
                             String vet,
                             String imagen) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Gato g = new Gato(nomMasc, codigoQR, nomProp, emailDue, numTel, direProp, edoReg, vet, imagen);
        g.grabar();
    }
    
    public void modificarVacunas(String codigoQR, 
                                 String rabia, 
                                 String leu, 
                                 String calic, 
                                 String panle, 
                                 String rino,
                                 String esteril,
                                 String comentarios) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Gato g = new Gato(codigoQR, rabia, leu, calic, panle, rino, esteril, comentarios);
        g.editarVacunas();
    }
    
    public int comprobarChip(String codigoQR) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Gato g = new Gato(codigoQR);
        return g.enviarChip();
    }
}
