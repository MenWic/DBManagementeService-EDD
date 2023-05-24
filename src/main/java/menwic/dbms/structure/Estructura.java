package menwic.dbms.structure;

import menwic.dbms.structure_fields.ListaCampos;
import menwic.dbms.tuple.ListaTuplas;

/**
 *
 * @author lamr4
 */
public class Estructura { //Ordenar en base a su nombre en Arbol B+ Principal

    private String tabla; //Nombre de Tabla/Estructura
    private String clave; //Nombre del campo que sera PrimaryKey
    private ListaCampos listaCampos; //ListaEnlazada que contiene el nombre de listaCampos/cols que tendra la Estructura/Tabla
    private ListaTuplas listaTuplas; //xd
    //private BPlusTree_Estructuras arbolPrincipal; //Arbol en el que se albergaran Tuplas

    //Constructor (Verificar: si construimos sin parametros, y luego seteamos los atributos del Objeto)
    public Estructura(String tabla, String clave) { //, ListaCampos listaCampos
        this.tabla = tabla;
        this.clave = clave;

        this.listaCampos = new ListaCampos();
        this.listaTuplas = new ListaTuplas();

    }

    //Temporal
    public Estructura() {
    }

    //Getters y Setters
    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ListaCampos getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(ListaCampos listaCampos) {
        this.listaCampos = listaCampos;
    }

    public ListaTuplas getListaTuplas() {
        return listaTuplas;
    }

    public void setListaTuplas(ListaTuplas listaTuplas) {
        this.listaTuplas = listaTuplas;
    }
    
    //Metodos de insertar Nodos a Arbol
    /*
    public void insertarTuplas(String[] listaTuplas) {
        this.arbolTuplas.insert(0, listaTuplas);
    }
     */
}
