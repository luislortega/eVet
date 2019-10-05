package clases;

import db.VeterinarioDB;
import java.net.SocketException;
import java.sql.SQLException;

/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.05.01
 */

public class Veterinario {
    
    private String id;
    private String user;
    private String pass;
    private String numTel;
    private String email;
    private String edo;
    private String dire;
    private String org;
    private String posc;
    private String licencia;
    private String mac;
    private String codLic;
    private String licenciaActiva;
    
    public Veterinario(String id){
        this.id = id;
    }
    
    public Veterinario(String user, String pass){
        this.user = user;
        this.pass = pass;
    }
    
    public Veterinario(int indice, String mac, String codLic, String id){
        this.mac = mac;
        this.id = id;
        this.codLic = codLic;
    }
    
    public Veterinario(String user, String numTel, String email, String dire, String org){
        this.user = user;
        this.numTel = numTel;
        this.email = email;
        this.dire = dire;
        this.org = org;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdo() {
        return edo;
    }

    public void setEdo(String edo) {
        this.edo = edo;
    }    

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }
    
    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPosc() {
        return posc;
    }

    public void setPosc(String posc) {
        this.posc = posc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getCodLic() {
        return codLic;
    }

    public void setCodLic(String codLic) {
        this.codLic = codLic;
    }

    public String getLicenciaActiva() {
        return licenciaActiva;
    }

    public void setLicenciaActiva(String licenciaActiva) {
        this.licenciaActiva = licenciaActiva;
    }
  
    public int IniciarSesion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        VeterinarioDB vdb = new VeterinarioDB(this);
        return vdb.VerificarLogin();
    }
    
    public int enviarID() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, SocketException{
        VeterinarioDB vdb = new VeterinarioDB(this);
        return vdb.VerificarLicencia();
    }
    
    public void enviarLicencia() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        VeterinarioDB vdb = new VeterinarioDB(this);
        vdb.ActivarLicencia();
    }
    
    public void enviarPass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        VeterinarioDB vdb = new VeterinarioDB(this);
        vdb.CambiarPass();
    }
    
    public void enviarInfo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        VeterinarioDB vdb = new VeterinarioDB(this);
        vdb.CambiarInfo();
    }
}
