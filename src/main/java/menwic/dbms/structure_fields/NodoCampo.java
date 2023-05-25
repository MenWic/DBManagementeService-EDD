package menwic.dbms.structure_fields;

/**
 *
 * @author lamr4
 */
public class NodoCampo {

    //Atributos globales principales
    private Campo campo; //Objeto principal
    private NodoCampo siguiente; //Puntero al proximo

    //Constructor
    public NodoCampo(Campo campo) {
        this.campo = campo;
        this.siguiente = null;
    }

    // Getters y Setters
    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public NodoCampo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCampo siguiente) {
        this.siguiente = siguiente;
    }
}
