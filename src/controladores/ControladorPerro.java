package controladores;

import clases.Perro;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class ControladorPerro {
    
    public void agregarPerro(String nomMasc, 
                             String codigoQR, 
                             String nomProp, 
                             String emailDue, 
                             String numTel, 
                             String direProp, 
                             String edoReg,
                             String vet,
                             String imagen) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Perro p = new Perro(nomMasc, codigoQR, nomProp, emailDue, numTel, direProp, edoReg, vet, imagen);
        p.grabar();
    }
    
    public void modificarVacunas(String codigoQR,
                                 String parvo,
                                 String moqui,
                                 String adeno,
                                 String rabia,
                                 String parain,
                                 String borda,
                                 String leptos,
                                 String influ,
                                 String esteril,
                                 String comentarios) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Perro p = new Perro(codigoQR, parvo, moqui, adeno, rabia, parain, borda, leptos, influ, esteril, comentarios);
        p.editarVacunas();
    }
    
    public int comprobarChip(String codigoQR) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Perro p = new Perro(codigoQR);
        return p.enviarChip();
    }
}
