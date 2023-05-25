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

    //Constructor
    public Tupla(ListaValores listaValores, String clave) {
        this.listaValores = listaValores;
        this.clave = clave;
    }

    //Metodo que crea una lista de valores a partir d eun array de valores
    public Tupla(Valor[] valores, String clave) {
        this.listaValores = new ListaValores();

        for (Valor itemValor : valores) { //Recorre cada nodo de valores
            this.listaValores.agregarAlFinal(itemValor);
        }
        this.clave = clave; //retorna la clave de cada nodo en cada iteracion
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
