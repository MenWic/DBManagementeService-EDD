package menwic.dbms.structure_fields;

/**
 *
 * @author lamr4
 */
public class NodoCampo {

    private Campo campo;
    private NodoCampo siguiente;

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
