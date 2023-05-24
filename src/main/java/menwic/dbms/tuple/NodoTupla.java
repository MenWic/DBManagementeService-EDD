package menwic.dbms.tuple;

/**
 *
 * @author lamr4
 */
public class NodoTupla {

    private Tupla tupla;
    private NodoTupla siguiente;

    public NodoTupla(Tupla valor) {
        this.tupla = valor;
        this.siguiente = null;
    }

    // Getters y Setters
    public Tupla getTupla() {
        return tupla;
    }

    public void setTupla(Tupla tupla) {
        this.tupla = tupla;
    }

    public NodoTupla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTupla siguiente) {
        this.siguiente = siguiente;
    }
}
