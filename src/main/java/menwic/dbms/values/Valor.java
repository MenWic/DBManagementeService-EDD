package menwic.dbms.values;

/**
 *
 * @author lamr4
 */
public class Valor {

    public String contenido;
    public String nombreCampo;

    public Valor(String valor, String nombreCampo) {
        this.contenido = valor;
        this.nombreCampo = nombreCampo;
    }

    //Getters y Setters
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }
    
}
