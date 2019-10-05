package clases;

import db.PerroDB;
import java.sql.SQLException;

/**
 * @author Luis
 * @version 0.05.01
 */

public class Perro {
    
    private String nomMasc, codigoQR, nomProp, emailDue, numTel, direProp, edoReg, vet; //Datos relevantes
    private String imagen; //imagen 
    private String parvo, moqui, adeno, rabia, parain, borda, leptos, influ, esteril, comentarios; //enfermedades
    
    //Constructor que se usara para verificar que existe el chip
    public Perro(String codigoQR){
        this.codigoQR = codigoQR;
    }
    
    //Constructor que se usara para guardar al perro
    public Perro(String nomMasc, 
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
    //Constructor que se usara para el manejo de vacunas
    public Perro(String codigoQR,
                 String parvo, 
                 String moqui,
                 String adeno,
                 String rabia,
                 String parain,
                 String borda,
                 String leptos,
                 String influ,
                 String esteril,
                 String comentarios){
        this.codigoQR = codigoQR;
        this.parvo = parvo;
        this.moqui = moqui;
        this.adeno = adeno;
        this.rabia = rabia;
        this.parain = parain;
        this.borda = borda;
        this.leptos = leptos;
        this.influ = influ;
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

    public void setCodigoQR(String codigosQR) {
        this.codigoQR = codigosQR;
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

    public String getParvo() {
        return parvo;
    }

    public void setParvo(String parvo) {
        this.parvo = parvo;
    }

    public String getMoqui() {
        return moqui;
    }

    public void setMoqui(String moqui) {
        this.moqui = moqui;
    }

    public String getAdeno() {
        return adeno;
    }

    public void setAdeno(String adeno) {
        this.adeno = adeno;
    }

    public String getRabia() {
        return rabia;
    }

    public void setRabia(String rabia) {
        this.rabia = rabia;
    }

    public String getParain() {
        return parain;
    }

    public void setParain(String parain) {
        this.parain = parain;
    }

    public String getBorda() {
        return borda;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    public String getLeptos() {
        return leptos;
    }

    public void setLeptos(String leptos) {
        this.leptos = leptos;
    }

    public String getInflu() {
        return influ;
    }

    public void setInflu(String influ) {
        this.influ = influ;
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
        PerroDB pdb = new PerroDB(this);
        pdb.GrabarPerro();
    }
    
    public void editarVacunas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        PerroDB pdb = new PerroDB(this);
        pdb.ModificarVacunas();
    }
    
    public int enviarChip() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        PerroDB pdb = new PerroDB(this);
        return pdb.VerificarCodigo();
    }
}
