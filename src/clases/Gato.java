package clases;

import db.GatoDB;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version  0.05.01
 */

public class Gato {
    
    private String nomMasc, codigoQR, nomProp, emailDue, numTel, direProp, edoReg, vet; //Datos relevantes
    private String imagen; //imagen 
    private String rabia, leu, calic, panle, rino, esteril, comentarios;
    
    //Constructor que se usara para verificar el chip
    public Gato(String codigoQR){
        this.codigoQR = codigoQR;
    }
    //Constructor que se usara para guardar al gato
    public Gato(String nomMasc, 
                 String codigoQR, 
                 String nomProp, 
                 String emailDue, 
                 String numTel, 
                 String direProp, 
                 String edoReg,
                 String vet,
                 String imagen)
    {
        this.nomMasc = nomMasc;
        this.codigoQR = codigoQR;
        this.nomProp = nomProp;
        this.emailDue = emailDue;
        this.numTel = numTel;
        this.direProp = direProp;
        this.edoReg = edoReg;
        this.vet = vet;
        this.imagen = imagen;
    }   
    
    public Gato(String codigoQR, 
                String rabia, 
                String leu, 
                String calic, 
                String panle, 
                String rino,
                String esteril,
                String comentarios){
        this.codigoQR = codigoQR;
        this.rabia = rabia;
        this.leu = leu;
        this.calic = calic;
        this.panle = panle;
        this.rino = rino;
        this.esteril = esteril;
        this.comentarios = comentarios;
    }

    public String getNomMasc() {
        return nomMasc;
    }

    public void setNomMasc(String nomMasc) {
        this.nomMasc = nomMasc;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public String getNomProp() {
        return nomProp;
    }

    public void setNomProp(String nomProp) {
        this.nomProp = nomProp;
    }

    public String getEmailDue() {
        return emailDue;
    }

    public void setEmailDue(String emailDue) {
        this.emailDue = emailDue;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getDireProp() {
        return direProp;
    }

    public void setDireProp(String direProp) {
        this.direProp = direProp;
    }

    public String getEdoReg() {
        return edoReg;
    }

    public void setEdoReg(String edoReg) {
        this.edoReg = edoReg;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRabia() {
        return rabia;
    }

    public void setRabia(String rabia) {
        this.rabia = rabia;
    }

    public String getLeu() {
        return leu;
    }

    public void setLeu(String leu) {
        this.leu = leu;
    }

    public String getCalic() {
        return calic;
    }

    public void setCalic(String calic) {
        this.calic = calic;
    }

    public String getPanle() {
        return panle;
    }

    public void setPanle(String panle) {
        this.panle = panle;
    }

    public String getRino() {
        return rino;
    }

    public void setRino(String rino) {
        this.rino = rino;
    }

    public String getEsteril() {
        return esteril;
    }

    public void setEsteril(String esteril) {
        this.esteril = esteril;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    public void grabar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        GatoDB gdb = new GatoDB(this);
        gdb.GrabarGato();
    }
    
    public void editarVacunas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        GatoDB gdb = new GatoDB(this);
        gdb.ModificarVacunas();
    }
    
    public int enviarChip() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        GatoDB gdb = new GatoDB(this);
        return gdb.VerificarCodigo();
    }
}
