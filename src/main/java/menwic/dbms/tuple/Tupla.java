package menwic.dbms.tuple;

import menwic.dbms.values.ListaValores;
import menwic.dbms.values.Valor;

/**
 *
 * @author lamr4
 */
public class Tupla {

    //public String nombreCampo;
    public String clave;
    public ListaValores listaValores;

    public Tupla(ListaValores listaValores, String clave) {
        this.listaValores = listaValores;
        this.clave = clave;
    }

    /**
     * Crea una lista de valores a partir d eun array de valores
     *
     * @param valores
     * @param clave
     */
    public Tupla(Valor[] valores, String clave) {
        this.listaValores = new ListaValores();

        for (Valor itemValor : valores) {
            this.listaValores.agregarAlFinal(itemValor);
        }
        this.clave = clave;
    }

    //Getters y Setters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ListaValores getListaValores() {
        return listaValores;
    }

    public void setListaValores(ListaValores listaValores) {
        this.listaValores = listaValores;
    }
}
