package menwic.dbms.structure;

import menwic.dbms.values.ListaValores;

/**
 *
 * @author lamr4
 */
public class NodoEstructura {

    private Estructura estructura; //Objeto principal
    private NodoEstructura siguiente;
    private ListaValores listaTuplas;

    public NodoEstructura(Estructura estructura) {
        this.estructura = estructura;
        this.siguiente = null;
    }

    // Getters y Setters
    public Estructura getEstructura() {
        return estructura;
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public NodoEstructura getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstructura siguiente) {
        this.siguiente = siguiente;
    }
}
