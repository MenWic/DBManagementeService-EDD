package menwic.dbms.values;

/**
 *
 * @author lamr4
 */
public class NodoValor {
    private Valor valor;
    private NodoValor siguiente;

    public NodoValor(Valor valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    // Getters y Setters
    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public NodoValor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoValor siguiente) {
        this.siguiente = siguiente;
    }
}
