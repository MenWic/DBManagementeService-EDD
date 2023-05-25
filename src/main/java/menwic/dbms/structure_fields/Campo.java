package menwic.dbms.structure_fields;

/**
 *
 * @author lamr4
 */
public class Campo {

    //Atributos globales principales
    private String nombreCampo;
    private String tipoDato;
    private Campo campoReferencia; //Puntero OPCIONAL hacia otro Campo (de otra Tabla/Estructura)

    //Constructor: Campos sin campoReferencia a otra Tabla/Entidad
    public Campo(String nombreCampo, String tipoDato) {
        this.nombreCampo = nombreCampo;
        this.tipoDato = tipoDato;
    }

    // Getters y Setters
    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    //MALA PRACTICA: Acceder a un Campo de OTRO Objeto y poderlo maniuplar desde aca por el setter
    public Campo getCampoReferencia() {
        return campoReferencia;
    }

    public void setCampoReferencia(Campo campoReferencia) {
        this.campoReferencia = campoReferencia;
    }
}
