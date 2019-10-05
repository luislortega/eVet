package servicios;
/**
 * @author Luis Gerardo Leon Ortega
 * @version 0.02.01
 */
public class Error {
    
    private long codigo;
    private String mensaje;
    
    public Error(long codigo, String mensaje){
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
    
    public long codigo(){
        return codigo;
    }
    public String mensaje(){
        return mensaje;
    }
}
