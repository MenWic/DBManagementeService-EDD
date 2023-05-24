package menwic.dbms.structure_fields;

/**
 *
 * @author lamr4
 */
public class Campo {
    private String nombre;
    private String tipoDato;
    private Campo referencia; //Puntero OPCIONAL hacia otro Campo (de otra Tabla/Estructura)
    
    //Constructor: Campos sin referencia a otra Tabla/Entidad
    public Campo(String nombre, String tipoDato) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Campo getReferencia() {
        return referencia;
    }

    public void setReferencia(Campo referencia) {
        this.referencia = referencia;
    }
}
